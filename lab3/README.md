# [Лабораторная работа №3. Использование автоматических генераторов анализаторов Bison и ANTLR](problems.pdf)
## Вариант 3. Перевод с Python на Си
Выберите подмножество языка Python и напишите транслятор, который переводит программы на заданном подмножестве на язык Си.

Вы можете выбрать небольшое подмножество языка, но на входе и на выходе вашего транслятора должны быть компилирующиеся программы.

_Пример:_
```
a = int(input())
b = int(input())
print(a + b)
```

_Вывод:_
```
int a, b;
int main() {
    scanf("%d", &a);
    scanf("%d", &b);
    printf("%d\n", a + b);
    return 0;
}
```