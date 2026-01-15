const swiper = new Swiper('.swiper', {
  slidesPerView: 1,
  effect: "creative",
  creativeEffect: {
    prev: {
      translate: [0, 0, -400],
    },
    next: {
      translate: ["100%", 0, 0],
    },
  },
  loop: true,
  direction: 'horizontal',
  autoplay: {
    delay: 5000,
  },
  speed: 400,
  spaceBetween: 100,
});


const swiper2 = new Swiper('.swiper2', {
  slidesPerView: 3,
  spaceBetween: 35,
  slidesPerGroup: 1,
  loop: true,
  centerSlides: true,
  grabCursor: true,
  loopFillGroupWithBlank: true,
  autoplay: {
    delay: 4000,
  },
  speed: 500,
  breakpoints: {
    0: { slidesPerView: 1 },
    768: { slidesPerView: 2 },
    1024: { slidesPerView: 3 },
  },
});



const swiper3 = new Swiper('.swiper3', {
  slidesPerView: 3,
  spaceBetween: 35,
  slidesPerGroup: 1,
  loop: true,
  centeredSlides: true,
  grabCursor: true,
  loopFillGroupWithBlank: true,

  autoplay: {
    delay: 3000,
    disableOnInteraction: false,
  },

  speed: 600,


     breakpoints: {
    // when window width is >= 320px
    320: {
      slidesPerView: 1,
      
    },
    // when window width is >= 480px
    700: {
      slidesPerView: 1,
    },
    // when window width is >= 640px
    850: {
      slidesPerView: 2,
    }
  }
});


const swiper4 = new Swiper('.swiper4', {
  slidesPerView: 2,
  spaceBetween: 100,
  slidesPerGroup: 1,
  loop: true,
  centeredSlides: true,
  grabCursor: true,
  loopFillGroupWithBlank: true,

  autoplay: {
    delay: 5000,
    disableOnInteraction: false,
  },

  speed: 400,

     breakpoints: {
    // when window width is >= 320px
    320: {
      slidesPerView: 1,
      
    },
    // when window width is >= 480px
    700: {
      slidesPerView: 1,
    },
    // when window width is >= 640px
    850: {
      slidesPerView: 1,
    }
  }
});


const counterObserver = new IntersectionObserver(
  (entries, observer) => {
    entries.forEach(entry => {
      if (entry.isIntersecting) {
        counters.forEach(counter => {
          const updateCount = () => {
            const target = +counter.getAttribute('data-target');
            const count = +counter.innerText;
            const inc = target / speed;
            if (count < target) {
              counter.innerText = Math.ceil(count + inc);
              setTimeout(updateCount, 40);
            } else {
              counter.innerText = target;
            }
          };
          updateCount();
        });
        observer.disconnect(); // Run once only
      }
    });
  },
  { threshold: 0.5 }
);

counters.forEach(counter => counterObserver.observe(counter));
