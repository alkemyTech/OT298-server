package com.alkemy.ong.util;

public class Constants {
    public static final String ROLE_ADMIN = "ROLE_ADMIN";
    public static final String ROLE_USER = "ROLE_USER";
    public static final String[] ALL_ROLES = {ROLE_ADMIN, ROLE_USER};

    public static final Integer PAGE_SIZE = 10;

    public static final String FIRST_PAGE = "0";
    public static abstract class Endpoints {
        public static final String USER = "/users";
        public static final String USER_UPDATE = USER + "/{id}";
        public static final String SLIDE = "/slides";
        public static final String SLIDE_UPDATE = SLIDE + "{/id}";
        public static final String MEMBER = "/members";
        public static final String MEMBER_UPDATE = MEMBER + "/{id}";
        public static final String API_UI_ANTMATCHER = "/api/**";
        public static final String API_DESCRIPTION_ANTMATCHER = "/v3/**";
    }
}
