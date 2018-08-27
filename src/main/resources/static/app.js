var { Router,
      Route,
      IndexRoute,
      IndexLink,
      Link } = ReactRouter;


var CardVisual =  React.createClass({
    render:function() {
       var cardVisualStyle = {
            padding:0,
            margin:0,
            borderRadius: 5,
            width: 230,
            height:250,
            verticalAlign:"center",
            display: "table",
            marginRight:"auto",
            marginLeft:"auto",
            marginTop: 10,
            paddingTop:10,
            backgroundColor: this.props.bgColor,
            verticalAlign: "center"
        };

        var pStyle = {
            color:"#FFFFFF",
            fontSize: 64,
            fontFamily: "sans-serif",
            textAlign: "center"
        }
        return (
        <div style={cardVisualStyle}>
           <p style={pStyle}> {this.props.databaseName} </p>
        </div>
        );
    }
});

var DatabaseButton = React.createClass({
    render:function() {
    var buttonStyle = {
                    backgroundColor: "#4CAF50",
                    border: "none",
                    borderRadius:5,
                    color: "white",
                    padding: "10px 32px",
                    textAlign: "center",
                    textDecoration: "none",
                    display: "inline-block",
                    fontSize: 16,
                    margin: "4px 2px",
                    cursor: "pointer"
            }
    return (
     <h2><a style={buttonStyle}>{this.props.databaseName}</a></h2>
     );
    }
})

var DatabaseDetailsBox =  React.createClass({
    render:function() {
       var databaseDetailsStyle = {
            padding:0,
            margin:0,
            width: 250,
            height:35,
            backgroundColor: "#FFF",
            display: "inline-block",
            fontFamily: "sans-serif",
            fontSize: 12,
            textAlign: "center"
        };


        return (
        <div style={databaseDetailsStyle}>
           <DatabaseButton {...this.props}/>
           <p>Database Size:{this.props.sizeInMB}</p>
           <p>Number of Collections:{this.props.numberCollections}</p>
           <p>Sharded:{this.props.isSharded}</p>
        </div>
        );
    }
});

var DatabaseCard = React.createClass({

    render:function() {
        var databaseCardStyle = {
            height:450,
            width:260,
            borderRadius: 5,
            padding:0,
            margin:10,
            backgroundColor:"#FFF",
            alignItems : "flex-start",
            verticalAlign : "center",
            WebKitFilter: "drop-shadow(0px 0px 5px #666)",
            filter: "drop-shadow(0px 0px 5px #666)"
        };
        return (
        <div style={databaseCardStyle}>
            <CardVisual {...this.props}/>
            <DatabaseDetailsBox {...this.props}/>
        </div>
        );
    }
});

var HorizontalDatabaseCardPane = React.createClass({

  loadDatabasesFromServer: function() {

    var self = this;
    $.ajax({
        url: "http://localhost:8100/databases/all",
      }).then(function(data) {
        self.setState({ databases: data});
      });

  },
  getInitialState: function() {
    return { databases: [] };
  },
  componentDidMount: function() {
    this.loadDatabasesFromServer();
  },
  render:function() {
          var horizontalBoxStyle = {
              height:"100%",
              width:"800",
              padding:0,
              backgroundColor:"#2b2727",
              display:"flex",
              alignItems:"initial",
              paddingLeft:20,
              verticalAlign: "top"
          };
    var renderData = [];
    for(var i=0;i<this.state.databases.length;i++){
        var card = <DatabaseCard databaseName={this.state.databases[i].databaseName} sizeInMB="100" numberCollections="5" isSharded="false" bgColor={"#"+((1<<24)*Math.random()|0).toString(16)}/>
        renderData.push(card);
    }
    return (<div style={horizontalBoxStyle}>{renderData}</div> );
  }
});

var ResourcesPage = React.createClass({
    render:function() {
        return(
            <div>
                 <ul>
                     <li><a href="http://localhost:8100/swagger-ui.html">REST Docs</a></li>
                     <li><a href="https://github.com/ryanhedges15/evie">GitHub Project</a></li>
                 </ul>
            </div>
        )
    }
});

var SubmitButton = React.createClass({
    render:function() {
    var buttonStyle = {
                    backgroundColor: "#4CAF50",
                    border: "none",
                    borderRadius:5,
                    color: "white",
                    padding: "10px 32px",
                    textAlign: "center",
                    textDecoration: "none",
                    display: "inline-block",
                    fontSize: 16,
                    right: 60,
                    position:"absolute",
                    margin: "0px 0px",
                    cursor: "pointer"
            }
    return (
     <h2><a style={buttonStyle}>Submit</a></h2>
     );
    }
})

var Editor = React.createClass({
  render:function() {
    var editorStyle = {
        height:100,
        overflow:"hidden",
        themeClass:"editorTheme"
    }
    return(
    <div>
        <pre id="editor" style={editorStyle} data-editor-lang="js">

        </pre>
        <SubmitButton />
    </div>
    )
    }
});

var App = React.createClass({
  render:function() {
    return(
    <div>
       <h1>EVIE MongoDB Manager</h1>
       <ul className="header">
          <li><a>Home</a></li>
          <li><a>Databases</a></li>
          <li><a>Cluster Health</a></li>
          <li><a>Development Resources</a></li>
        </ul>
        <HorizontalDatabaseCardPane />
        <Editor />
    </div>
    );
  }
});







 ReactDOM.render(
    <div>
        <Router>
//            <Route path="/" component={Editor}/>
            <Route path="/devtools" component={ResourcesPage}/>
        </Router>
    </div>,
     document.querySelector("#container")
 );



