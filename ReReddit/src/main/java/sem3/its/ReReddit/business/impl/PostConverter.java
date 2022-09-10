package sem3.its.ReReddit.business.impl;

import sem3.its.ReReddit.domain.Post;
import sem3.its.ReReddit.persistence.entity.PostEntity;

import java.util.ArrayList;
import java.util.List;

public class PostConverter {
    private PostConverter(){

    }
    public static  List<Post> convertList(List<PostEntity> list){
        List<Post> convertedPosts = new ArrayList<>();
        for(PostEntity p : list) {
            convertedPosts.add(Post.builder()
                    .id(p.getId())
                    .author(UserConverter.convert(p.getAuthor()))
                    .body(p.getBody())
                    .ups(p.getUps())
                    .downs(p.getDowns())
                    .header(p.getHeader())
                    .comments(CommentConverter.convertList(p.getComments()))
                    .build());
        }
        return convertedPosts;
    }
}
