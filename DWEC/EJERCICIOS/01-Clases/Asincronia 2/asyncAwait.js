async function myAsyncFunction(){
	try {
		const myData = await fetch('https://swapi.dev/api/people/1');
		return await myData.json();
	} catch (e) {
		console.log(e);
	}
}

console.log(myAsyncFunction());
/******************************************************/
