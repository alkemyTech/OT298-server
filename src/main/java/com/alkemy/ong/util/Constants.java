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
        public static final String USER = "/users";
        public static final String USER_UPDATE = USER + "/{id}";
        public static final String SLIDE = "/slides";
        public static final String SLIDE_UPDATE = SLIDE + "{/id}";

        public static final String TESTIMONIAL ="/testimonials";

        public static final String TESTIMONIAL_ID = "/{id}";

        public static final String TESTIMONIAL_PAGE = "/page";
    }
}
