package name.krot.crypto.hashing;

import name.krot.crypto.exception.HashException;

/**
 * Возвращает преобразованный массива входных данных произвольной длины в выходной массив данных установленной длины,
 * идентичную для идентичных входных данных
 *
 * @param <M> - массив входных данных произвольной длины
 * @param <H> – массив входных данных фиксированной длины
 * @throws HashException в случае любой ошибки хеширования
 * @implNote // todo реализовать имплементации не только строка в строку
 */
@FunctionalInterface
public interface Hash<H, M> {
    H hash(M m);
}
