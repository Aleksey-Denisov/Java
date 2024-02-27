package ru.gbhw.notes.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.gbhw.notes.model.Note;
import ru.gbhw.notes.repository.NoteRepository;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class NoteService {
    //Репозиторий
    private final NoteRepository noteRepository;

    //Получим конкретную заметку
    public Note getNoteById(Long id) {
        return noteRepository.findNoteById(id).orElse(null);
    }

    //Получим все заметки
    public List<Note> getAll() {
        return noteRepository.findAll();
    }

    //Добавление/Редактирование заметки
    public void save(Note note) {
        noteRepository.save(note);
    }

    //Удаление заметки
    public void delete(Long id) {
        noteRepository.deleteById(id);
    }
}
