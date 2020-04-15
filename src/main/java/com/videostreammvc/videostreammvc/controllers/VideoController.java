package com.videostreammvc.videostreammvc.controllers;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;

import javax.imageio.ImageIO;

import org.jcodec.api.FrameGrab;
import org.jcodec.api.JCodecException;
import org.jcodec.common.model.Picture;
import org.jcodec.scale.AWTUtil;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.MediaTypeFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class VideoController {

    String path = "C:/Users/mohammak/Documents/selflearning/first-video-streaming-app-mvc/first-video-streaming-mvc/video-stream-mvc/src/main/resources/static";

    @GetMapping("/videos/{name}")
    public ResponseEntity<UrlResource> getFullVideo(@PathVariable String name) throws MalformedURLException {
        UrlResource video = new UrlResource("file:" + path + "/videos/" + name);

        return ResponseEntity.status(HttpStatus.PARTIAL_CONTENT)
                .contentType(MediaTypeFactory.getMediaType(video).orElse(MediaType.APPLICATION_OCTET_STREAM))
                .body(video);
    }

    @GetMapping(value = "/video/{name}/image", produces = MediaType.IMAGE_JPEG_VALUE)
    public @ResponseBody byte[] getImage(@PathVariable String name) throws IOException, JCodecException {
        int frameNumber = 42;
        Picture picture = FrameGrab.getFrameFromFile(new File(path + "/videos/" + name), frameNumber);

        BufferedImage bufferedImage = AWTUtil.toBufferedImage(picture);
        ImageIO.write(bufferedImage, "png", new File(path+"/photos/frame.png"));

        // InputStream in = getClass().getResourceAsStream("/photos/frame.png");

        Path pathOutput = FileSystems.getDefault().getPath(path+"/photos/frame.png");

        return Files.readAllBytes(pathOutput);
    }
}

//first-video-streaming-mvc/video-stream-mvc/src/main/resources/static