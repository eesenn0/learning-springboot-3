// A key module needed to launch React
import { ReactDOM } from "react-dom"
// Imports the custom UI 
import { App } from "./App"
const app = document.getElementById("app")
ReactDOM.render(<App />, app)