//package com.company.kunuz.Util;

import com.company.kunuz.DTO.JwtDTO;
import com.company.kunuz.Enums.ProfileRole;
import com.company.kunuz.Exception.AppForbiddenException;
import jakarta.servlet.http.HttpServletRequest;

//public class HttpRequestUtil {


//    public static Integer getProfileId(HttpServletRequest request, ProfileRole requiredRole) {
//        Integer id = (Integer) request.getAttribute("id");
//        ProfileRole role = (ProfileRole) request.getAttribute("role");
//        if (!role.equals(requiredRole)) {
//            throw new ForbiddenException("Method not allowed");
//        }
//        return id;
//    }

//    public static JwtDTO getJwtDTO(HttpServletRequest request) {
//        Integer id = (Integer) request.getAttribute("id");
//        ProfileRole role = (ProfileRole) request.getAttribute("role");
//
//
//        JwtDTO dto = new JwtDTO(id, );
//        return dto;
//    }
//
//
//    public static JwtDTO getJwtDTO(HttpServletRequest request, ProfileRole requiredRole) {
//        Integer id = (Integer) request.getAttribute("id");
//        ProfileRole role = (ProfileRole) request.getAttribute("role");
//        JwtDTO dto = new JwtDTO(id, role);
//
//        if (!dto.getRole().equals(requiredRole)) {
//            throw new AppForbiddenException("Method not allowed");
//        }
//        return dto;
//    }
//
//


//}


