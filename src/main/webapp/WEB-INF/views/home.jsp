<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<div id="app">

                         
                         <h1>Vue form to FormEntity</h1>
                         
							<label><span>1. </span><strong>Name User:</strong></label>
							<input type="text" id="name" v-model="formInput.name"   />
						<br>
					<label><span>2. </span><strong>Age User:</strong></label>
							<input type = "number" id="age"v-model="formInput.age" />
						<br>
						<label><span>3. </span><strong>What about thinking:</strong></label>
							<input type="text"  id="things"v-model="formInput.things"  />
						<br>
						
						<input type="submit" class="all" value="Add" @click="createFormEntity(formInput)" @click="resetForm"/>
						<button @click="resetForm">Reset</button>
						<br>
						                     <h1>Change</h1>  
         <h3 >id = {{outSelects.id}}  <!--  <input type="text" id="idChange"  v-model="outSelects.id"/> --></h3>
           <h3>name   <input type="text" id="nameChange"  v-model="outSelects.name"/></h3>
            <h3>age   <input type="number" id="ageChange"  v-model="outSelects.age"/></h3>
               <h3>things   <input type="text" id="thingsChange"  v-model="outSelects.things"/></h3>
               <button id="change" @click="changeInfo(outSelects)" >Change</button>
               <button @click="resetChange">Reset</button>
               <br>
       
                <!--
                	<input type="text" id="nameChange">{{formEntity.name}}</span>
			<span  type="number" id="ageChange">{{formEntity.age}}</span>
				<span class=" type="text"  id="thingsChange">{{formEntity.things}}</span> -->     
				 <br>
				 
		 		  <input type="text" class="form-control" v-model="search"/>
				
				    <br>
				    
  	      <br>
		
				
	<button id="deleteSelect" v-on:click="deleteSelectFormEntity(checkBoxListId)"  @click="resetDataSelected">Delete Selecting Where id= {{checkBoxListId}}</button>
	 <br>
	
            <br>
       <table class="table">
      <thead>
        <tr>
         <th v-on:click="sortById = !sortById"> id </th>
          <th  v-on:click="sortByName =!sortByName"> name</th>
          <th v-on:click="sortByAge =!sortByAge">age</th>
          <th v-on:click="sortByThings =!sortByThings">things</th>
         <th>  <input type="checkbox"   @click = "selectAll" v-model="allSelected" />  </th>
        </tr>
      </thead>
      <tr v-for="formEntitys in filteredPerson">
        <td> {{ formEntitys.id }} </td>
        <td>{{ formEntitys.name }}</td>
        <td>{{ formEntitys.age }}</td>
        <td>{{ formEntitys.things }}</td>
        <td> <input type="checkbox"   v-bind:value=" formEntitys.id "  v-model="checkBoxListId" />  </td>
        <td>  <button id="change" v-on:click="getOutSelects(formEntitys.id)" >Change</button> </td>
        <td> <button id="delete" v-on:click="deleteformEntity(formEntitys,outSelects)" title="delete" >Delete</button>  </td>
      </tr>
  </table>
      	      <br>
		
			<!--  	<h1>For test</h1>
               
                         <ul v-for="formEntity in formEntitys ">
	<span class="label label-info">{{formEntity.id}}</span>
		<span class="label label-info">{{formEntity.name}}</span>
			<span class="label label-info">{{formEntity.age}}</span>
				<span class="label label-info">{{formEntity.things}}</span>
				<input type="checkbox"   v-bind:value=" formEntity.id "  v-model="checkBoxListId" />  
				<button id="change" v-on:click="getOutSelects(formEntity.id)" >Change</button>
				<button id="delete" v-on:click="deleteformEntity(formEntity,outSelects)" >Delete</button>
				</ul>
				-->
		
</div>

</body>
</html>


<script src="/resources/js/axios.min.js"></script>
 <script src="https://vuejs.org/js/vue.js"></script>
 <script src="https://cdnjs.cloudflare.com/ajax/libs/vue/2.5.13/vue.js"></script>
<script>




var vm = new Vue({
	el: "#app",
	data:{
		filterByName:[],
		search: '',
		formInput:[{
			name:'',
			age: '',
			things: ''
		}],
		formEntitys: [{
			name:'',
			age: '',
			things: ''
		}],
		item: {},
		outSelects: [],
		checkBoxListId: [],
		allSelected:false,
		sortById: false,
    	sortByName:false,
    	sortByAge:false,
    	sortByThings: false,
		serverUrl: "http://localhost:8080/api/v1"
	},
	  computed: {
	        filteredPerson: function () {
	            var self = this;
	            return this.formEntitys.filter(function (formEntitys) {
	                return formEntitys.name.toLowerCase().indexOf(self.search.toLowerCase()) >= 0
	                || formEntitys.things.toLowerCase().indexOf(self.search.toLowerCase()) >= 0;
	            });
	        }
	    },
	    watch: {
			sortById: function (val) {
				var self = this;
				self.formEntitys = self.sortBy(self.formEntitys, 'id', val);
			},
			sortByName: function (val) {
				var self = this;
				self.formEntitys = self.sortBy(self.formEntitys, 'name', val);
			},
			sortByAge: function (val) {
				var self = this;
				self.formEntitys = self.sortBy(self.formEntitys, 'age', val);
			},
			sortByThings: function (val) {
				var self = this;
				self.formEntitys = self.sortBy(self.formEntitys, 'things', val);
			}
	    },
	methods:{
	getFormEntitys: function(){
		var self = this;
		
		axios.get(this.serverUrl + "/all")
		.then(function(all){
			self.formEntitys = all.data;
			console.log(all);
		})
		.catch(function(error){
			console.log(error);
		});
	},
	  
	
	deleteformEntity: function(formEntity, outSelects){
		axios.get(this.serverUrl + "/delete?formid=" + formEntity.id)
		.then(function(status){
			console.log(status);
            if(formEntity.id == outSelects.id){
            	outSelects.length = 0;
            	vm.getOutSelects(outSelects);
            	vm.getFormEntitys();
            }else{
          
            }
            vm.getFormEntitys();
          
		//	location.reload(true);
		})
		.catch(function(error){
			console.log(error);
		});
	},
	
	deleteSelectFormEntity: function (checkBoxListId){
		axios.post(this.serverUrl + "/delete_selected", checkBoxListId)
		.then(function(response){
			console.log(response);
			
			vm.getFormEntitys();
		})
		.catch(function(error){
		console.log(error);	
		})
	},
	
	selectAll: function (){
		this.checkBoxListId = [];

        if (!this.allSelected) {
            for (formEntity in this.formEntitys) {
                this.checkBoxListId.push(this.formEntitys[formEntity].id);
            }}
	},
	
	createFormEntity : function(formInput){
		var self = this;
		
		axios.post( this.serverUrl + "/create" , {name : formInput.name, age : formInput.age, things : formInput.things})
		.then(function(status) {
			console.log(status);
			vm.resetForm();
			vm.getFormEntitys();
		
			
			
			
		})
		.catch(function(error){
			console.log(error);
		});

	},
	
	
	

	
	changeInfo : function(outSelects){
		 axios.post( this.serverUrl +"/change", outSelects)
		.then(function(status){
			console.log(status);
			vm.resetChange();
			vm.getFormEntitys();
		})
		.catch(function(error){
			console.log(error);
		});
	},
	
	getOutSelects: function(formEntity){
		var self = this;
		 axios.get( this.serverUrl +"/out?id=" + formEntity)
		.then(function(response){
			self.outSelects = response.data;
			console.log(outSelects);
		  alert(outSelects.name);
			vm.getFormEntitys();
			
		})
		.catch(function(error){
			console.log(error);
		});
	},
	  resetForm: function(e) {
          
          this.$data.formInput.name = "";
          this.$data.formInput.age = "";
          this.$data.formInput.things = "";
      },
 resetChange: function(e) {
	    this.$data.outSelects.id = "";
	    this.$data.outSelects.name = "";
	 	this.$data.outSelects.age= "";
		this.$data.outSelects.things= "";
      },
      
      resetDataSelected: function(e) {
  	    this.$data.checkBoxListId = [];
 
      },
      
      sortBy: function(array, param, reverse) {
  		var filterA, filterB;
  		return array.sort(function (a, b) {
  			switch (param) {
  				case 'id':
  					filterA = a.id;
  					filterB = b.id;
  					break;
  				case 'name':
  					filterA = a.name;
  					filterB = b.name;
  					break;
  				case 'age':
  					filterA = a.age;
  					filterB = b.age;
  					break;
  				case 'things':
  					filterA = a.things;
  					filterB = b.things;
  					break;
  			}
  			if (reverse) {
  				return (filterA > filterB) ? 1 : -1;
  			} else {
  				return (filterA < filterB) ? 1 : -1;
  			}
  		});
  	}
	

	},
	mounted() {
		this.getFormEntitys();
	}
	
});

</script>