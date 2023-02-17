package com.dreamtree.api.common.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

@Getter
@ToString
public class PageResponseDTO<E> {

    private int page;
    private int size;
    private int total;

    //시작 페이지 번호
    private int start;
    //끝 페이지 번호
    private int end;

    //이전 페이지의 존재 여부
    private int prev;
    //다음 페이지의 존재 여부
    private int next;

    private List<E> dtoList;

    private List<Long> pageNumList;


    @Builder(builderMethodName = "withAll")
            public PageResponseDTO(PageRequestDTO pageRequestDTO, List<E> dtoList, int total){

        if(total <= 0){
            return;
        }

        this.page = pageRequestDTO.getPage();
        this.size = pageRequestDTO.getSize();

        this.total = total;
        this.dtoList = dtoList;

        this.end =   (int)(Math.ceil(this.page / 10.0 )) *  10;

        this.start = this.end - 9;

        int last =  (int)(Math.ceil((total/(double)size)));

        this.end =  end > last ? last: end;

        this.prev = this.page > 1 ? this.page - 1 : 0;

        this.next =  this.page < (Math.ceil((double)this.total / (double)this.size)) ? this.page + 1 : 0;

        this.pageNumList = LongStream.rangeClosed(start,end).boxed().collect(Collectors.toList());

    }
}