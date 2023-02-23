package com.dreamtree.api.domain.category.controller;

import com.dreamtree.api.domain.category.dto.LayoutInfoDTO;
import com.dreamtree.api.domain.category.service.CategoryService;
import com.dreamtree.api.domain.parent.service.ParentService;
import com.dreamtree.api.domain.student.service.StudentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

//이승윤 ver0.1
@RestController
@Log4j2
@RequestMapping("api/category/")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    private final StudentService studentService;

    private final ParentService parentService;

    private final ModelMapper modelMapper;

    @GetMapping("layout")
    public LayoutInfoDTO getCategoryLists(){

        List categoryListDTO = categoryService.getCategoryList();

/*

        */
/*유저가 로그인 했을 경우만!*//*

        if(id != 0){
            if(role.equalsIgnoreCase(RoleEnum.PARENT.toString())){
                ParentInfoResDTO memberInfo = parentService.getOneParentInfo(id);
                memberDTO = modelMapper.map(memberInfo, MemberDTO.class);
            } else{
                StudentDetailDTO memberInfo = studentService.getStudent(id);
                memberDTO = modelMapper.map(memberInfo, MemberDTO.class);
            }
        }
*/

        return LayoutInfoDTO.builder()
                .categories(categoryListDTO)
                .build();
    }
}