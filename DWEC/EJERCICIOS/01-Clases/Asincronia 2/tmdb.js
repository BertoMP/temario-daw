// Reemplaza 'TU_API_KEY' con tu clave de API de TMDb
const apiKey = 'faf373bd1d1b728d923fba7978306a11';

// ID de la película que te interesa
const movieId = 157336;  // Reemplaza con el ID de la película deseada

// Hacer la solicitud a la API para obtener los detalles de la película
fetch(`https://api.themoviedb.org/3/search/movie?api_key=${apiKey}&query=infity-war`)
	.then(response => response.json())
	.then(movieData => {
		// Acceder a las imágenes
		const posterPath = movieData.poster_path;
		const backdropPath = movieData.backdrop_path;

		// Construir URL completa para las imágenes
		const posterUrl = `https://image.tmdb.org/t/p/original/${posterPath}`;
		const backdropUrl = `https://image.tmdb.org/t/p/w1280/${backdropPath}`;

		// Puedes usar las URLs de las imágenes como desees (por ejemplo, asignarlas a la fuente de una imagen en tu HTML)
		console.log('URL del póster:', posterUrl);
		console.log('URL del fondo:', backdropUrl);
	})
	.catch(error => console.error('Error al obtener los detalles de la película:', error));