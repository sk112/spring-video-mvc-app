const React = require('react');
const ReactDOM = require('react-dom');

class App extends React.Component {

	constructor(props) {
		super(props);
	}

	componentDidMount() {
		console.log('mounting app..');
		
    }
    
    componentWillMount(){
        console.log("will mount..");
    }

	render() { 
		return (
            <video width="500px" controls>
                <source src="/videos/Sample1.mp4" type="video/mp4" />
            </video>
		)
	}
}



ReactDOM.render(<App/>, document.getElementById("react"));
// ReactDOM.render(<Thumbnail />, document.getElementById("thumbnail"));