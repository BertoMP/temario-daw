function printPoster(poster_path) {
	const myImage = document.getElementById('myImage');
	myImage.src = `https://image.tmdb.org/t/p/w500${poster_path}`;
}

const options = {
	method: 'GET',
	headers: {
		accept: 'application/json',
		Authorization: 'Bearer eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiJmYWYzNzNiZDFkMWI3MjhkOTIzZmJhNzk3ODMwNmExMSIsInN1YiI6IjY1Yjk1ZDY1ZjkwYjE5MDE2MzA0NWYzMyIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.O9aBowUOACChmKISsdJd50xbf8rNKExE_EBBgl-Rukk'
	}
};

fetch('https://api.themoviedb.org/3/movie/157336', options)
	.then(res => res.json())
	.then(res => printPoster(res.poster_path))
	.catch(err => console.log(err))