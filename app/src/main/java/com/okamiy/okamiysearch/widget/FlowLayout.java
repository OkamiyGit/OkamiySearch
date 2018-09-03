package com.okamiy.okamiysearch.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * @author Okamiy
 * @date 2018\8\31 0031 11:38
 * 流式布局
 */
public class FlowLayout extends ViewGroup {
    private int horizontalSpacing = 13;
    private int verticalSpacing = 13;

    private ArrayList<Line> lineList = new ArrayList<Line>();

    public FlowLayout(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    public FlowLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public FlowLayout(Context context) {
        super(context);
    }

    public void setHorizontalSpacing(int horizontalSpacing) {
        this.horizontalSpacing = horizontalSpacing;
    }

    public void setVerticalSpacing(int verticalSpacing) {
        this.verticalSpacing = verticalSpacing;
    }

    /**
     * 遍历所有的子View，进行分行的逻辑操作，相当于定好座位表
     */
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        lineList.clear();

        int width = MeasureSpec.getSize(widthMeasureSpec);
        int noPaddingWidth = width - getPaddingLeft() - getPaddingRight();

        Line line = new Line();
        for (int i = 0; i < getChildCount(); i++) {
            View childView = getChildAt(i);
            childView.measure(0, 0);

            if (line.getViewList().size() == 0) {
                line.addLineView(childView);
            } else if (childView.getMeasuredWidth() + line.getLineWidth() + horizontalSpacing > noPaddingWidth) {
                lineList.add(line);


                line = new Line();
                line.addLineView(childView);
            } else {

                line.addLineView(childView);
            }


            if (i == (getChildCount() - 1)) {
                lineList.add(line);
            }

        }


        int height = getPaddingTop() + getPaddingBottom();

        for (int i = 0; i < lineList.size(); i++) {
            height += lineList.get(i).getLineHeight();
        }

        height += (lineList.size() - 1) * verticalSpacing;


        setMeasuredDimension(width, height);
    }

    /**
     * 将所有的line中的子View摆放到指定的位置上
     */
    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        for (int i = 0; i < lineList.size(); i++) {
            Line line = lineList.get(i);

            if (i > 0) {
                paddingTop += lineList.get(i - 1).getLineHeight() + verticalSpacing;
            }

            ArrayList<View> viewList = line.getViewList();

            int remainSpacing = getLineRemainSpacing(line);
            float perSpacing = remainSpacing / viewList.size();
            for (int j = 0; j < viewList.size(); j++) {
                View child = viewList.get(j);
                if (lineList.size() > 1 && i < lineList.size() - 1) {

                    int widthSpec = MeasureSpec.makeMeasureSpec((int) (child.getMeasuredWidth() + perSpacing), MeasureSpec.EXACTLY);
                    child.measure(widthSpec, 0);
                } else {
                    child.measure(0, 0);
                }


                if (j == 0) {
                    child.layout(paddingLeft, paddingTop, paddingLeft + child.getMeasuredWidth()
                            , paddingTop + child.getMeasuredHeight());
                } else {
                    View preChild = viewList.get(j - 1);

                    int left = preChild.getRight() + horizontalSpacing;
                    child.layout(left, preChild.getTop(), left + child.getMeasuredWidth(), preChild.getBottom());
                }
            }
        }
    }

    /**
     * 获取指定line对象的留白值
     *
     * @param line
     * @return
     */
    private int getLineRemainSpacing(Line line) {
        return getMeasuredWidth() - getPaddingLeft() - getPaddingRight() - line.getLineWidth();
    }

    /**
     * 行对象，用来封装每一行的数据，包括子View，宽度和高度
     *
     * @author Administrator
     */
    class Line {
        private ArrayList<View> viewList = new ArrayList<View>();

        private int lineWidth;

        private int lineHeight;

        /**
         * 往viewList中添加view对象
         *
         * @param child
         */
        public void addLineView(View child) {
            if (!viewList.contains(child)) {
                viewList.add(child);

                if (viewList.size() == 1) {
                    lineWidth = child.getMeasuredWidth();
                } else {
                    lineWidth += horizontalSpacing + child.getMeasuredWidth();
                }

                lineHeight = Math.max(lineHeight, child.getMeasuredHeight());
            }
        }


        public ArrayList<View> getViewList() {
            return viewList;
        }

        public int getLineWidth() {
            return lineWidth;
        }


        public int getLineHeight() {
            return lineHeight;
        }
    }
}
