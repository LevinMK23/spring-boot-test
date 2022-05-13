package ru.learnUp.springboottest.service.mq;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.io.InputStream;

@RestController
public class MessageController {

    private final MessageProducer messageProducer;
    private final FilesDirectoryProvider filesDirectoryProvider;

    public MessageController(MessageProducer messageProducer,
                             FilesDirectoryProvider filesDirectoryProvider) {
        this.messageProducer = messageProducer;
        this.filesDirectoryProvider = filesDirectoryProvider;
    }

    @GetMapping("/message")
    public String sendMessage(@RequestParam String message) {
        messageProducer.sendMessage(message);
        return "OK";
    }

    @GetMapping(
            value = "/getFile",
            produces = MediaType.APPLICATION_OCTET_STREAM_VALUE
    )
    public @ResponseBody byte[] getFile() throws IOException {
        InputStream in = getClass()
                .getResourceAsStream("file.txt");
        assert in != null;
        return in.readAllBytes();
    }

    @GetMapping("/file/write")
    public String writeIntoFile(
            @RequestParam String fileName,
            @RequestParam String text
    ) throws IOException {
        filesDirectoryProvider.writeString(fileName, text);
        return fileName;
    }

    @GetMapping(
            value = "/file/data/{fileName}",
            produces = MediaType.APPLICATION_OCTET_STREAM_VALUE
    )
    public @ResponseBody byte[] getFile(@PathVariable String fileName) throws IOException {
        return filesDirectoryProvider.getFile(fileName);
    }



}
