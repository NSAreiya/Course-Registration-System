package com.example.Course.Registration.Project.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;

import com.example.Course.Registration.Project.model.Users;

// Disabled - Using MongoDB Atlas instead
// @Repository
// @Primary
public class InMemoryUserDetailsRepo implements UserDetailsRepo {

    private final Map<String, Users> userStore = new ConcurrentHashMap<>();
    private long idCounter = 1;

    @Override
    public Users getByUsername(String username) {
        return userStore.get(username);
    }

    @Override
    public <S extends Users> S save(S entity) {
        if (entity.getId() == null) {
            entity.setId(String.valueOf(idCounter++));
        }
        userStore.put(entity.getUsername(), entity);
        return entity;
    }

    @Override
    public <S extends Users> List<S> saveAll(Iterable<S> entities) {
        List<S> result = new ArrayList<>();
        entities.forEach(entity -> result.add(save(entity)));
        return result;
    }

    @Override
    public Optional<Users> findById(String id) {
        return userStore.values().stream()
                .filter(user -> user.getId().equals(id))
                .findFirst();
    }

    @Override
    public boolean existsById(String id) {
        return findById(id).isPresent();
    }

    @Override
    public List<Users> findAll() {
        return new ArrayList<>(userStore.values());
    }

    @Override
    public List<Users> findAllById(Iterable<String> ids) {
        List<Users> result = new ArrayList<>();
        ids.forEach(id -> findById(id).ifPresent(result::add));
        return result;
    }

    @Override
    public long count() {
        return userStore.size();
    }

    @Override
    public void deleteById(String id) {
        userStore.values().removeIf(user -> user.getId().equals(id));
    }

    @Override
    public void delete(Users entity) {
        userStore.remove(entity.getUsername());
    }

    @Override
    public void deleteAllById(Iterable<? extends String> ids) {
        ids.forEach(this::deleteById);
    }

    @Override
    public void deleteAll(Iterable<? extends Users> entities) {
        entities.forEach(this::delete);
    }

    @Override
    public void deleteAll() {
        userStore.clear();
    }

    @Override
    public List<Users> findAll(Sort sort) {
        return findAll();
    }

    @Override
    public Page<Users> findAll(Pageable pageable) {
        throw new UnsupportedOperationException("Pagination not supported in in-memory implementation");
    }

    @Override
    public <S extends Users> S insert(S entity) {
        return save(entity);
    }

    @Override
    public <S extends Users> List<S> insert(Iterable<S> entities) {
        return saveAll(entities);
    }

    @Override
    public <S extends Users> Optional<S> findOne(Example<S> example) {
        throw new UnsupportedOperationException("Example queries not supported in in-memory implementation");
    }

    @Override
    public <S extends Users> List<S> findAll(Example<S> example) {
        throw new UnsupportedOperationException("Example queries not supported in in-memory implementation");
    }

    @Override
    public <S extends Users> List<S> findAll(Example<S> example, Sort sort) {
        throw new UnsupportedOperationException("Example queries not supported in in-memory implementation");
    }

    @Override
    public <S extends Users> Page<S> findAll(Example<S> example, Pageable pageable) {
        throw new UnsupportedOperationException("Example queries not supported in in-memory implementation");
    }

    @Override
    public <S extends Users> long count(Example<S> example) {
        return count();
    }

    @Override
    public <S extends Users> boolean exists(Example<S> example) {
        throw new UnsupportedOperationException("Example queries not supported in in-memory implementation");
    }

    @Override
    public <S extends Users, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        throw new UnsupportedOperationException("Fluent queries not supported in in-memory implementation");
    }
}
