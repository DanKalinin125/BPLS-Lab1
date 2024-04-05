package com.example.bplslab1;

import com.example.bplslab1.dto.*;
import com.example.bplslab1.entity.Comment;
import com.example.bplslab1.entity.Image;
import com.example.bplslab1.entity.News;

import java.io.ByteArrayOutputStream;
import java.sql.Date;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.Deflater;
import java.util.zip.Inflater;

public class Utils {
    public static Date getCurrentDateTime(){
        return new Date(Instant.now().toEpochMilli());
    }


    public static byte[] compressImage(byte[] data) {
        Deflater deflater = new Deflater();
        deflater.setLevel(Deflater.BEST_COMPRESSION);
        deflater.setInput(data);
        deflater.finish();

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
        byte[] tmp = new byte[4*1024];
        while (!deflater.finished()) {
            int size = deflater.deflate(tmp);
            outputStream.write(tmp, 0, size);
        }
        try {
            outputStream.close();
        } catch (Exception ignored) {
        }
        return outputStream.toByteArray();
    }


    public static byte[] decompressImage(byte[] data) {
        Inflater inflater = new Inflater();
        inflater.setInput(data);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
        byte[] tmp = new byte[4*1024];
        try {
            while (!inflater.finished()) {
                int count = inflater.inflate(tmp);
                outputStream.write(tmp, 0, count);
            }
            outputStream.close();
        } catch (Exception ignored) {
        }
        return outputStream.toByteArray();
    }

    public static ImageDTO imageToImageDTO(Image image){
        return ImageDTO.builder()
                .id(image.getId())
                .name(image.getName())
                .type(image.getType())
                .build();
    }

    public static NewsInListDTO newsToNewsInListDTO(News news){
        return NewsInListDTO.builder()
                .image(Utils.imageToImageDTO(news.getImage()))
                .title(news.getTitle())
                .creationDateTime(news.getCreationDateTime())
                .build();
    }

    public static News newsCreateDTOToNews(NewsCreateDTO newsCreateDTO, Image image){
        return News.builder()
                .image(image)
                .title(newsCreateDTO.getTitle())
                .text(newsCreateDTO.getText())
                .creationDateTime(getCurrentDateTime())
                .build();
    }

    public static List<CommentDTO> commentListToCommentDTOList(List<Comment> commentList){
        List<CommentDTO> commentDTOList = new ArrayList<>();
        for (Comment comment : commentList){
            commentDTOList.add(CommentDTO.builder()
                    .id(comment.getId())
                    .text(comment.getText())
                    .username(comment.getUsername())
                    .creationDateTime(comment.getCreationDateTime())
                    .build());
        }
        return commentDTOList;
    }

    public static NewsPageDTO newsToNewsPageDTO(News news){
        return NewsPageDTO.builder()
                .image(imageToImageDTO(news.getImage()))
                .title(news.getTitle())
                .text(news.getText())
                .creationDateTime(news.getCreationDateTime())
                .commentList(commentListToCommentDTOList(news.getCommentList())).build();
    }

    public static Comment commentCreateDTOToComment(CommentCreateDTO dto, News news){
        return Comment.builder()
                .news(news)
                .username(dto.getUsername())
                .email(dto.getEmail())
                .text(dto.getText())
                .creationDateTime(getCurrentDateTime())
                .build();
    }

    public static CommentDTO commentToCommentDTO(Comment comment){
        return CommentDTO.builder()
                .id(comment.getId())
                .username(comment.getUsername())
                .email(comment.getEmail())
                .text(comment.getText())
                .creationDateTime(comment.getCreationDateTime())
                .build();
    }
}
