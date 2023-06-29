<h1 align="center">Digital Chief</h1> 
<h2> Tools</h2>
Java(17), Spring Framework(Boot, Data JPA), Hibernate, MySQL, Maven, Lombok, REST, Flyway
<h3> Задание: </h3>
<p>1. Выбрать предметную область. На основе выбранной области, придумать композицию,
состоящей из не менее 2 объектов, отношения между которыми "один ко многим". Пример
композиций: город - достопримечательность, университет - факультет, студент - оценка
по предмету. Необходимо в произвольной форме сделать описание предметной области,
выбранной композиции и использумые в ней объекты. Для каждого объекта описать не
менее 5 свойств.</p>
<p>2. Создать Git репозиторий в котором будут хранится все файлы необходимые для сборки
и запуска будущего приложения.</p>
<p>3. Установить реляционную базу данных (БД) на выбор: MySQL или PostgreSQL. Создать
схему БД для хранения и управления данными для смоделированных объектов. Добавить
файлы инициализации схемы данных в Git репозиторий. Дополнительным, совсем
необязательным, плюсом будет использование Docker контейнера для БД.</p>
<p> 4. Создать REST API приложение в архитектурном стиле MVC на основе фрэймворка
Spring Boot. Требования:
- Java, версия от 8+
- приложение содержит пул подключений к БД
- имплементированы классы-модели в Java для отображения смоделированных
объектов
- решена задача объектно-реляционного отображения
- создан интерфейс API (Application Programming Interface) на основе архитектурного
стиля REST для проведения CRUD (Create, Read, Update, Delete) операций над
объектами. Взаимодействие с API реализовано в формате JSON
- в корне проекта содержится README.md файл. README.md содержит описание всех
зависимостей подключенных в проект, а также пошаговые инструкции для сборки и
запуска приложения
- подготовлены по одному примеру запроса для каждого эндпоинта в одном из
следующих форматов: сURL, HTTP, wget. Примечание: можно сгенерировать результат с
использованием инструмента тестирования Postman или инструмента автоматической
генерации документации Swagger. При использовании Postman добавить файлы
коллекции Postman в структуру проекта.</p>
<h2>Описание предметной области:</h2>
Библиотека.
<p>Продукт: имеет id, название, описание, ISBN, дату выпуска, авторов, жанры, издателя.</p>
<p> Автор: имеет id, имя, дату рождения. Связь с книгой @ManyToMany. </p>
<p> Жанр: : имеет id,  название. Связь с книгой @ManyToMany. </p>
<p> Издатель: : имеет id,  имя, адрес. Связь с книгой @OneToMany. </p>
<h2>Описание зависимостей:</h2>
> spring-boot-starter-parent </p>
Специальный стартер, который обеспечивает полезные значения по умолчанию Maven.</p>
> spring-boot-starter-test </p>
Основная зависимость, содержащая большинство элементов, необходимых для тестов.</p>
> mysql-connector-j</p>
Предоставляет приложениям Java возможность соединения с базой данных MySQL.</p>
> modelmapper</p>
Библиотека, которая помогает маппить объекты из одной модели в другую, уменьшая потребность в сопоставлении кода вручную.</p>
> org.projectlombok:lombok</p>
Основанная на аннотациях библиотека Java, позволяющая сократить шаблонный код.</p>
> spring-boot-starter-validation</p>
Используется для валидации.</p>
> flyway-core, flyway-mysql</p>
Инструмент для контроля версии базы данных.</p>
<h2>Запуск приложения:</h2>
Склонируйте репозиторий: git clone https://github.com/OlyaEna/digitalchief.git </p>
D MySQL Workbanch создайте Schema под названием "digital_chief". Сменить название можно в application.properties. </p>
Запустить склонированный код необходимо через IDE,для работы с БД к проекту подкючены миграции. </p>
<h2>Примеры запросов:</h2>
- Автор </p>
![ime](https://github.com/OlyaEna/digitalchief/blob/master/src/main/resources/templates/img/author_all.JPG) </p>
![ime](https://github.com/OlyaEna/digitalchief/blob/master/src/main/resources/templates/img/author_create.JPG)
![ime](https://github.com/OlyaEna/digitalchief/blob/master/src/main/resources/templates/img/author_delete.JPG)
![ime](https://github.com/OlyaEna/digitalchief/blob/master/src/main/resources/templates/img/author_name.JPG)
![ime](https://github.com/OlyaEna/digitalchief/blob/master/src/main/resources/templates/img/author_update.JPG)
- Жанр
![ime](https://github.com/OlyaEna/digitalchief/blob/master/src/main/resources/templates/img/genre_all.JPG)
![ime](https://github.com/OlyaEna/digitalchief/blob/master/src/main/resources/templates/img/genre_create.JPG)
- Издатель
![ime](https://github.com/OlyaEna/digitalchief/blob/master/src/main/resources/templates/img/publisher_all.JPG)
- Продукт
![ime](https://github.com/OlyaEna/digitalchief/blob/master/src/main/resources/templates/img/product_all.JPG)
![ime](https://github.com/OlyaEna/digitalchief/blob/master/src/main/resources/templates/img/product_create.JPG)
![ime](https://github.com/OlyaEna/digitalchief/blob/master/src/main/resources/templates/img/product_delete.JPG)
![ime](https://github.com/OlyaEna/digitalchief/blob/master/src/main/resources/templates/img/product_genre.JPG)
![ime](https://github.com/OlyaEna/digitalchief/blob/master/src/main/resources/templates/img/product_name.JPG)
- Валидация и проверка на исключения
![ime](https://github.com/OlyaEna/digitalchief/blob/master/src/main/resources/templates/img/author_valid.JPG)
![ime](https://github.com/OlyaEna/digitalchief/blob/master/src/main/resources/templates/img/genre_valid.JPG)
![ime](https://github.com/OlyaEna/digitalchief/blob/master/src/main/resources/templates/img/genre_valid2.JPG)
![ime](https://github.com/OlyaEna/digitalchief/blob/master/src/main/resources/templates/img/genre_valid3.JPG)
![ime](https://github.com/OlyaEna/digitalchief/blob/master/src/main/resources/templates/img/product_valid.JPG)
![ime](https://github.com/OlyaEna/digitalchief/blob/master/src/main/resources/templates/img/publisher_valid.JPG)


