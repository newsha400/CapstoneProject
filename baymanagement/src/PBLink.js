import React, { Component } from 'react';
import { BrowserRouter, Route } from 'react-router-dom'
import './App.css';
import axios from 'axios'

class PBLink extends Component {


	constructor(props) {
		super(props)
		this.clickHandler = this.clickHandler.bind(this)
		this.componentWillMount = this.componentWillMount.bind(this)
		this.render = this.render.bind(this)
		this.state={
			id: this.props.location.state.paletteInfo.id,
			width: this.props.location.state.paletteInfo.width,
			length: this.props.location.state.paletteInfo.length,
			height:this.props.location.state.paletteInfo.height,
			dep:this.props.location.state.paletteInfo.dep,
			class:this.props.location.state.paletteInfo.paletteClass,
			category:this.props.location.state.paletteInfo.category,
		}


 }
	
	  componentWillMount() {
	  	let pId = this.props.match.params.id;
	  	let bays = axios.get(`http://localhost:8080/getEmptyBays?id=${pId}`).then((response)=>{
	  		console.log(response.data)
	  		const bayList = response.data.map((bay)=>{
	  			return (<div className="subBayDisplay" onClick={()=>this.bayClick(bay)}>
						<p>SubBay ID: {bay.id}</p>
						<p>SubBay Width: {bay.width}</p>
						<p>SubBay Height: {bay.height}</p>
						<p>SubBay Length: {bay.length}</p>
						<p>SubBay Dept: {bay.dep}</p>
						<p>SubBay BayClass: {bay.bayClass}</p>
						<p>SubBay Category: {bay.category}</p>
					</div>)
			})
	  		console.log(bayList)
	  		this.setState({
	  			bayList: bayList
	  		})
	  	})

	  }

	bayClick(bay){		
		let palette = {}
		palette.id= this.state.id;
		palette.width= this.state.width;
		palette.length =  this.state.length;
		palette.height = this.state.height;
		palette.dep = this.state.dep
		palette.paletteClass = this.state.class
		palette.category = this.state.category;
		palette.bay = bay.id

		axios.post(`http://localhost:8080/editPalette`,palette).then(console.log("mission accomplished"))
		
	}  
	clickHandler(event) {
		//push new data to db !!!
		event.preventDefault();
		console.log('we chose this', this.state.selectedOption)
		// const pId = event.target[0].value
		const pId = 'p5643245'
		this.props.history.push(`/load/${pId}`)
	}

	render() {
		return (
			
			<div>
				<h1>Select a bay location</h1>
				{this.state.bayList}

				{/*<ol>
					{this.state.persons.map(person => 
					<li 
					onClick = 
					{ this.state.selectedOption = person.name,
					this.clickHandler
					}>
					{person.name}
					</li>)
				}
				</ol>*/}
			</div>

		)
	}
}

//<PastInfo pastINfo={this.state.pastInfo}> --> call this as props in the next one 
//in the PastInfo ---> 
//oconstructor(props) { super (props)}
// wrap this inside of a function ---> let weeklySales = this.props.pastInfo
export default PBLink