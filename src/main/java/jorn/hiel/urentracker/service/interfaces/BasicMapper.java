package jorn.hiel.urentracker.service.interfaces;

public interface BasicMapper <T, S >
{
    public T mapToObj(S dto);
    public S mapToDto(T obj);
}
