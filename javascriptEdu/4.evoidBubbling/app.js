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

        li.innerHTML = `<input type="checkbox" /> ${text}`;

        li.addEventListener(
            "click",
            (ev) => {
                var [input] = li.getElementsByTagName("input");

                var hasInputClicked = ev.target === input;

                if (hasInputClicked) {
                    input.checked = !input.checked;
                }
            },
            false
        );
        return li;
    }
})();
