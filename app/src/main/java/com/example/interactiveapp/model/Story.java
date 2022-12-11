package com.example.interactiveapp.model;

import com.example.interactiveapp.R;

public class Story {
    Page[] mPages;

    public Story() {
        mPages = new Page[7];

        mPages[0] = new Page(
                R.drawable.page0,
                R.string.PAGE0_TEXT,
    new Choice(R.string.PAGE0_CHOICE_1_TEXT, 1),
                        new Choice(R.string.PAGE0_CHOICE_2_TEXT, 2)
                );
        mPages[1] = new Page(
                R.drawable.page1,
                R.string.PAGE1_TEXT,

                        new Choice(R.string.PAGE1_CHOICE_1_TEXT, 3),
                        new Choice(R.string.PAGE1_CHOICE_2_TEXT, 4)
                );

        mPages[2] = new Page(
                R.drawable.page2,
                R.string.PAGE2_TEXT,

                        new Choice(R.string.PAGE2_CHOICE_1_TEXT, 4),
                        new Choice(R.string.PAGE2_CHOICE_2_TEXT, 6)
                );

        mPages[3] = new Page(
                R.drawable.page3,
                R.string.PAGE3_TEXT,

                        new Choice(R.string.PAGE3_CHOICE_1_TEXT, 4),
                        new Choice(R.string.PAGE3_CHOICE_2_TEXT, 5)
                );

        mPages[4] = new Page(
                R.drawable.page4,
                R.string.PAGE4_TEXT,

                        new Choice(R.string.PAGE4_CHOICE_1_TEXT, 5),
                        new Choice(R.string.PAGE4_CHOICE_2_TEXT, 6)
                );

        mPages[5] = new Page(
                R.drawable.page5,
                R.string.PAGE5_TEXT);

        mPages[6] = new Page(
                R.drawable.page6,
                R.string.PAGE6_TEXT);
    }

    public Page getPage(int page_id) {
        if(page_id > 0 && page_id < mPages.length) {
            return mPages[page_id];
        }
        return mPages[0];
    }
}
