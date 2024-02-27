package ru.gbhw.notes.controller;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.Timer;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.gbhw.notes.model.Note;
import ru.gbhw.notes.service.NoteService;

import java.time.LocalDateTime;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

@RestController
@RequiredArgsConstructor
public class NoteController {
    //Сервис
    private final NoteService noteService;
    //Переменные для отображения метрик
    private final Timer timer;
    private final Counter counter;

    //Добавление заметки
    @PostMapping
    public ResponseEntity<Void> addNote(@RequestBody Note note) {
        note.setCreationDate(LocalDateTime.now());
        timer.record(() -> noteService.save(note));
        counter.increment();
        return ResponseEntity.ok().build();
    }
    //Получение всех заметок
    @GetMapping
    public ResponseEntity<List<Note>> getAll() {
        counter.increment();
        return timer.record(() -> new ResponseEntity<>(noteService.getAll(), HttpStatus.OK));
    }
    //Получение конкретной заметки
    @GetMapping("/{id}")
    public ResponseEntity<Note> getNote(@PathVariable Long id) {
        counter.increment();
        AtomicReference<Note> atNote = new AtomicReference<>();
        timer.record(() -> {
            atNote.set(noteService.getNoteById(id));
        });
        Note note = atNote.get();
        if(note == null)
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        else
            return new ResponseEntity<>(note, HttpStatus.FOUND);
    }
    //Изменение конкретной заметки
    @PutMapping("/{id}")
    public ResponseEntity<Void> updateNote(@PathVariable Long id, @RequestBody Note note) {
        counter.increment();
        AtomicReference<Note> atNote = new AtomicReference<>();
        timer.record(()->{
            atNote.set(noteService.getNoteById(id));
        });
        Note oldNote = atNote.get();
        if(oldNote == null)
            return ResponseEntity.notFound().build();
        else {
            note.setId(id);
            note.setCreationDate(oldNote.getCreationDate());
            noteService.save(note);
            return ResponseEntity.ok().build();
        }
    }
    //Удаление заметки
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        counter.increment();
        AtomicReference<Note> atNote = new AtomicReference<>();
        timer.record(()->{
            atNote.set(noteService.getNoteById(id));
        });
        Note note = atNote.get();
        if(note == null)
            return ResponseEntity.notFound().build();
        else {
            noteService.delete(id);
            return ResponseEntity.ok().build();
        }
    }
}
