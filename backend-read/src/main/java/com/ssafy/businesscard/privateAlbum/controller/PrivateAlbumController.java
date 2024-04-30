package com.ssafy.businesscard.privateAlbum.controller;

import com.ssafy.businesscard.global.utils.MessageUtils;
import com.ssafy.businesscard.privateAlbum.dto.FilterListResponseDto;
import com.ssafy.businesscard.privateAlbum.dto.PrivateAlbumListDto;
import com.ssafy.businesscard.privateAlbum.dto.PrivateAlbumResponseDto;
import com.ssafy.businesscard.privateAlbum.service.PrivateAlbumService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
@CrossOrigin("*")
public class PrivateAlbumController {

    private final PrivateAlbumService privateAlbumService;

    //명함지갑에서목록조회
    @GetMapping("/my-album/list/{user_id}/{page}")
    public ResponseEntity<List<PrivateAlbumResponseDto>> getAlbumList(
            @PathVariable("user_id")Long userId,
            @PathVariable("page")int page){

        List<PrivateAlbumResponseDto> list = privateAlbumService.getAlbumList(userId, page);
        return ResponseEntity.ok().body(MessageUtils.success(list).getDataBody());
    }

    //명함 상세 조회
    @GetMapping("/my-album/{user_id}/{card_id}")
    public ResponseEntity<PrivateAlbumResponseDto> getAlbumDtail(
            @PathVariable("user_id")Long userId,
            @PathVariable("card_id")Long cardId){
        PrivateAlbumResponseDto privateAlbumResponseDto = privateAlbumService.getAlbumDtail(userId, cardId);
        return ResponseEntity.ok().body(MessageUtils.success(privateAlbumResponseDto).getDataBody());
    }

    //필터 목록 조회
    @GetMapping("/my-album/{user_id}/filter")
    public ResponseEntity<List<FilterListResponseDto>> getFilter(@PathVariable("user_id")Long userId){
        List<FilterListResponseDto> list = privateAlbumService.getFilter(userId);
        return ResponseEntity.ok().body(MessageUtils.success(list).getDataBody());
    }


}
