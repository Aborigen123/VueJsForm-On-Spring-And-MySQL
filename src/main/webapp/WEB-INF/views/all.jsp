<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>All</h1>

<div id="demo">
    <input type="text" class="form-control" v-model="search"/>
    
    <br/>
    <table class="table">
      <thead>
        <tr>
         <th v-on:click="sortById = !sortById"> id </th>
          <th  v-on:click="sortByName =!sortByName"> name</th>
          <th v-on:click="sortByAge =!sortByAge">eyes</th>
          <th v-on:click="sortByThings =!sortByThings">age</th>
        </tr>
      </thead>
      <tr v-for="formEntitys in filteredPerson">
        <td> {{ formEntitys.id }} </td>
        <td>{{ formEntitys.name }}</td>
        <td>{{ formEntitys.age }}</td>
        <td>{{ formEntitys.things }}</td>
      </tr>
  </table>
</div>
</body>
<script src="${rootUrl}/resources/js/axios.min.js"></script>
<script src="${rootUrl}/resources/js/vue.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/vue/2.5.13/vue.js"></script>
<script>

var app = new Vue({
    el: '#demo',
    data: {
        search: '',
        people: [
          {name: 'Koos', age: 30, eyes:'red'},
          {name: 'Gert', age: 20, eyes:'blue'},
          {name: 'Pieter', age: 12, eyes:'green'},
          {name: 'Dawid', age: 67, eyes:'dark green'},
          {name: 'Johan', age: 15, eyes:'purple'},
          {name: 'Hans', age: 12, eyes:'pink'}
        ],
    	sortById: false,
    	sortByName:false,
    	sortByAge:false,
    	sortByThings: false,
    		
        formEntitys:[],
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
	console.log( all);
	})
	.catch(function(error){
		console.log(error);
	});
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
					filterA = a.old;
					filterB = b.old;
					break;
				case 'things':
					filterA = a.status;
					filterB = b.status;
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
</html>

