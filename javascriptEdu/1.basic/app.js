"use strict";

(function () {
    document.getElementById("clickme").addEventListener(
        "click",
        () => {
            var input = document.getElementById("myInput").value;
            alert(input);
        },
        false
    );
})();