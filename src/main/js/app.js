const React = require('react');
const ReactDOM = require('react-dom');

function App(){
	return (
		<video width="500px" controls>
			<source src="/videos/Sample1.mp4" type="video/mp4" />
		</video>
	)
}

function Thumbnail(){
	return(
		<img src="/video/Sample1.mp4/image" style={{maxHeight: "100px", maxWidth: "100px"}} ></img>
	)
}

ReactDOM.render(
<div>
	<Thumbnail />
	<App/>
</div>
, document.getElementById("thumbnail"));