"use strict";

(function () {
    var textInput = document.getElementById("textInput");
    var button = document.getElementById("addTodoButton");
    var list = document.getElementById("todoList");
    var totalCounter = document.querySelector("#total");
    var incompleteCounter = document.querySelector("#incomplete");
    var completeCounter = document.querySelector("#complete");

    function updateCounter() {
        var totalCount = document.querySelectorAll("li").length;
        var completeCount = document.querySelectorAll(".complete").length;
        var incompleteCount = totalCount - completeCount;

        totalCounter.textContent = `전체 : ${totalCount}`;
        completeCounter.textContent = `완료 : ${completeCount}`;
        incompleteCounter.textContent = `미완료 : ${incompleteCount}`;
    }

    button.addEventListener("click", addTodo, false);

    function addTodo() {
        var li = newTodo(textInput.value);

        list.appendChild(li);

        updateCounter();
    }

    function newTodo(text) {
        var li = document.createElement("li");

        li.innerHTML = `<input type="checkbox" /> ${text} <button>삭제</button>`;

        li.querySelector("button").addEventListener("click", (ev) => {
            ev.stopPropagation();
            li.parentNode.removeChild(li);
            updateCounter();
        });

        li.addEventListener(
            "click",
            (ev) => {
                var [input] = li.getElementsByTagName("input");

                var hasInputClicked = ev.target === input;

                if (!hasInputClicked) {
                    input.checked = !input.checked;
                }

                if (input.checked) {
                    li.className = "complete";
                } else {
                    li.className = "";
                }

                updateCounter();
            },
            false
        );
        return li;
    }
})();
