"use strict";

(function () {
    var textInput = document.getElementById("textInput");
    var button = document.getElementById("addTodoButton");
    var list = document.getElementById("todoList");

    button.addEventListener("click", addTodo, false);

    function addTodo() {
        var li = newTodo(textInput.value);

        list.appendChild(li);
    }

    function newTodo(text) {
        var li = document.createElement("li");

        // li.textContent = text;

        // li.innerHTML = '<input type="checkbox" />' + text;

        li.innerHTML = `<input type="checkbox" /> ${text}`;

        li.addEventListener(
            "click",
            () => {
                var [input] = li.getElementsByTagName("input");
                input.checked = !input.checked;
            },
            false
        );

        li.getElementsByTagName("input")[0].addEventListener(
            "click",
            (ev) => {
                ev.stopPropagation();
            },
            false
        );

        return li;
    }
})();
