const apiKey = "4a9a5554";
const modal = document.getElementById("modal");
const subtitulo = document.getElementById("subtitulo");
const titulo = document.getElementById("titulo");

function searchMovies() {
  const query = document.getElementById("search").value;

  fetch(`https://www.omdbapi.com/?apikey=${apiKey}&s=${query}`)
    .then(res => res.json())
    .then(data => {
      const moviesDiv = document.getElementById("movies");
      moviesDiv.innerHTML = "";

      if (data.Response === "True") {
        data.Search.forEach(movie => {
          const movieEl = document.createElement("div");
          movieEl.classList.add("movie");

          movieEl.innerHTML = `
            <img src="${movie.Poster !== 'N/A' ? movie.Poster : ''}">
            <h3>${movie.Title}</h3>
            <p>${movie.Year}</p>
          `;
          subtitulo.innerText = "Resultados"
         titulo.style.margin = "40px 0 0"
          movieEl.onclick = () => getMovieDetails(movie.imdbID);

          moviesDiv.appendChild(movieEl);
        });
      } else {
        moviesDiv.innerHTML = `<p>${data.Error}</p>`;
      }
    })
    .catch(error => {
      console.error("Error:", error);
    });
}

function getMovieDetails(id) {
  fetch(`https://www.omdbapi.com/?apikey=${apiKey}&i=${id}`)
    .then(res => res.json())
    .then(movie => {
      const details = document.getElementById("details");

      details.innerHTML = `
        <h2>${movie.Title}</h2>
        <p><strong>Año:</strong> ${movie.Year}</p>
        <p><strong>Género:</strong> ${movie.Genre}</p>
        <p><strong>Director:</strong> ${movie.Director}</p>
        <p><strong>Plot:</strong> ${movie.Plot}</p>
      `;

      modal.style.display = "flex";
    });
}

function closeModal() {
  modal.style.display = "none";
}

const populares = ["Dexter", "jujutsu kaisen", "Kimetsu no Yaiba", "Death Note"];

window.onload = function () {
  populares.forEach(titulo => {
    fetch(`https://www.omdbapi.com/?apikey=${apiKey}&t=${titulo}`)
      .then(res => res.json())
      .then(movie => {
        const moviesDiv = document.getElementById("movies");
        const movieEl = document.createElement("div");
        movieEl.classList.add("movie");
        movieEl.innerHTML = `
          <img src="${movie.Poster !== 'N/A' ? movie.Poster : ''}">
          <h3>${movie.Title}</h3>
          <p>${movie.Year}</p>
        `;
        movieEl.onclick = () => getMovieDetails(movie.imdbID);
        moviesDiv.appendChild(movieEl);
      });
  });
};
