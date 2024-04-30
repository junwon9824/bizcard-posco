package com.ssafy.businesscard.privateAlbum.controller;

import com.ssafy.businesscard.global.utils.MessageUtils;
import com.ssafy.businesscard.privateAlbum.dto.PrivateAlbumListDto;
import com.ssafy.businesscard.privateAlbum.dto.PrivateAlbumResponseDto;
import com.ssafy.businesscard.privateAlbum.service.PrivateAlbumService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
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
}