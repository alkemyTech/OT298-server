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
        public static final String MEMBER = "/members";
        public static final String MEMBER_UPDATE = MEMBER + "/{id}";
        public static final String API_UI_ANTMATCHER = "/api/**";
        public static final String API_DESCRIPTION_ANTMATCHER = "/v3/**";

        public static final String TESTIMONIAL ="/testimonials";
        public static final String TESTIMONIAL_ID = "/{id}";
        public static final String TESTIMONIAL_PAGE = "/page";
    }

    public static abstract class httpCodes{
        public static final String STATUS_OK = "200";
        public static final String STATUS_CREATED = "201";
        public static final String STATUS_NO_CONTENT = "204";
        public static final String STATUS_BAD_REQUEST = "400";
        public static final String STATUS_FORBIDDEN = "403";
        public static final String STATUS_NOT_FOUND = "404";
    }

    public static abstract class messagesForDocs{

        public static final String BEARER_AUTH = "Bearer Authentication";
        public static final String GET_CATEGORIES = "Get all categories";
        public static final String GET_CATEGORIES_SUCCESSFUL = "Get all categories successfully";
        public static final String INVALID_PAGE = "Invalid page number";
        public static final String PAGE_NOT_FOUND = "Page not found";
        public static final String NO_CATEGORIES = "There are no categories";
        public static final String FORBIDDEN = "Action forbidden";
        public static final String GET_CATEGORY_ID = "Get category by id";
        public static final String CATEGORY_NOT_FOUND = "Category not found";
        public static final String GET_CATEGORY_SUCCESSFUL = "Get category successfully";
        public static final String ADD_CATEGORY = "Add new category";
        public static final String CATEGORY_CREATED = "Category added successfully";
        public static final String BAD_REQUEST = "Bad request";


    }
}
