package com.swell.code.platform.common;

public class Constant {

    public static final String DEFAULT_PASSWORD = "123456";

    /**
     * 是否
     *
     * @author FinnWells
     */
    public static final class YesOrNo {
        /**
         * 是
         */
        public static final Integer YES = 1;

        /**
         * 否
         */
        public static final Integer NO = 0;

    }

    /**
     * 字典类型
     *
     * @author FinnWells
     */
    public static final class DictTypes {
        /**
         * 字典项
         */
        public static final Integer dict = 1;
        /**
         * 字典组
         */
        public static final Integer group = 2;

    }

    /**
     * 字典组字典代码分类
     *
     * @author FinnWells
     */
    public static final class DictCodes {
        /**
         * 性别
         */
        public static final String GENDER = "gender";

    }

    public static final class DateTypes {
        public static final String DAY = "DAY";
        public static final String WEEK = "WEEK";
        public static final String MONTH = "MONTH";
        public static final String YEAR = "YEAR";

    }

    public static final class Statements {
        public static final String QUERY_ALL_MENU = "platform.menu.queryAll";
        public static final String QUERY_MENU_BYUSER = "platform.menu.queryByUser";
        public static final String QUERY_MENUIDS_BYUSER = "platform.menu.queryIdsByUser";
    }
}
