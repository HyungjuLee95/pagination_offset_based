package com.example.fastcampusmysql.application.Controller;


import com.example.fastcampusmysql.domain.post.dto.DailyPostCount;
import com.example.fastcampusmysql.domain.post.dto.DailyPostCountRequest;
import com.example.fastcampusmysql.domain.post.dto.PostCommand;
import com.example.fastcampusmysql.domain.post.entitiy.Post;
import com.example.fastcampusmysql.domain.post.service.PostReadService;
import com.example.fastcampusmysql.domain.post.service.PostWriteService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/posts")
public class PostController {
    final private PostWriteService postWriteService;
    final private PostReadService postReadService;

    @PostMapping("")
    public Long create(PostCommand command){
        return postWriteService.create(command);
    }

    @PostMapping("/daily-post-counts")
    public List<DailyPostCount> getDailyPostCounts( @RequestBody DailyPostCountRequest request){
        return postReadService.getDailyPostCounts(request);
    }

    @PostMapping("/member/{memberId}")
    public Page<Post> getPosts(
            @PathVariable Long memberId,
            Pageable pageable

    ){
        return postReadService.getPosts(memberId, pageable);
    }


}
