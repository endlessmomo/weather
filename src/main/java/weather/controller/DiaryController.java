package weather.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import weather.domain.Diary;
import weather.service.DiaryService;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class DiaryController {
    private final DiaryService diaryService;

    // Get형식 -> 조회할 때
    // Post형식 -> 저장할 때
    @PostMapping("/create/diary")
    void createDiary(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date
            , @RequestBody String text
    ) {
        diaryService.createDiary(date, text);
    }

    @GetMapping("/read/diary")
    List <Diary> readDiary(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date
    ) {
        return diaryService.readDiary(date);
    }
    @GetMapping("/read/diaries")

    List<Diary> readDiarys(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate
    ) {
        return diaryService.readDiares(startDate, endDate);
    }
}
