"use strict";

(function () {
    var textInput = document.getElementById("textInput");
    var button = document.getElementById("addTodoButton");
    var list = document.getElementById('todoList');

    function addTodo() {
        var li = document.createElement('li');

        li.textContent = textInput.value;

        textInput.value = '';

        list.appendChild(li);
    }

    button.addEventListener("click", addTodo, false);

})();