package com.alkemy.ong.util;

public class Constants {
    public static final String ROLE_ADMIN = "ROLE_ADMIN";
    public static final String ROLE_USER = "ROLE_USER";
    public static final String[] ALL_ROLES = {ROLE_ADMIN, ROLE_USER};

    public static final String URI_PAGE_TESTIMONIAL = "/testimonials/page?numberPage=";

    public static final Integer PAGE_SIZE = 10;

    public static final String FIRST_PAGE = "0";

    public static final Integer FIRST_PAGE_INTEGER = 0;

    public static abstract class Endpoints {
        public static final String ID = "/{id}";
        public static final String PAGE = "/page";
        public static final String PAGE_QUERY = "?page=*";
        public static final String USER = "/users";
        public static final String USER_ID = USER + ID;
        public static final String SLIDE = "/slides";
        public static final String SLIDE_ID = SLIDE + ID;
        public static final String CONTACT = "/contacts";
        public static final String ORGANIZATION = "/organization/public";
        public static final String ORGANIZATION_ID = ORGANIZATION + ID;
        public static final String COMMENT = "/comments";
        public static final String NEWS = "/news";
        public static final String NEWS_ID = NEWS + ID;
        public static final String NEWS_ID_COMMENT = NEWS + ID + COMMENT;
        public static final String ACTIVITY = "/activities";
        public static final String CATEGORY = "/categories";
        public static final String CATEGORY_ID = CATEGORY + ID;
        public static final String MEMBER = "/members";
        public static final String MEMBER_ID = MEMBER + ID;
        public static final String MEMBER_PAGE = MEMBER + PAGE_QUERY;
        public static final String API_UI_ANTMATCHER = "/api/**";
        public static final String API_DESCRIPTION_ANTMATCHER = "/v3/**";
        public static final String TESTIMONIAL ="/testimonials";
        public static final String TESTIMONIAL_ID = TESTIMONIAL + ID;
        public static final String TESTIMONIAL_PAGE = TESTIMONIAL + PAGE;
    }
}

