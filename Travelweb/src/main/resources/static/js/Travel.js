const menus = document.querySelector("nav ul");
const menuBtn = document.querySelector(".menu-btn");
const closeBtn = document.querySelector(".close-btn");

menuBtn.addEventListener("click", () => {
  menus.classList.add("display");
});

closeBtn.addEventListener("click", () => {
  menus.classList.remove("display");
});

//scorll sticky navbar//
const Header = document.querySelector("header");
window.addEventListener("scroll", () => {
  if (document.documentElement.scrollTop > 20) {
    Header.classList.add("sticky");
  } else {
    Header.classList.remove("sticky");
  }
});


//Static Numbers/////
const countersEL = document.querySelectorAll(".numbers");

countersEL.forEach((counter) => {
  counter.textContent = "0";

  function incrementCounters() {
    let currentNum = +counter.textContent;
    const dataCeil = +counter.getAttribute("data-ceil"); // convert to number
    const increment = dataCeil / 50; // smaller divisor = faster count

    currentNum = Math.ceil(currentNum + increment);

    if (currentNum < dataCeil) {
      counter.textContent = currentNum;
      setTimeout(incrementCounters, 70); // recursion
    } else {
      counter.textContent = dataCeil; // final value
    }
  }

  incrementCounters(); // start
});
