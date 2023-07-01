import { Component,Input } from '@angular/core';

@Component({
  selector: 'app-country-filter',
  template:`
  <div class="container">
    <h2>Country Filter</h2>
  <input type="text" data-test-id="app-input" [(ngModel)]="filterText" (input)="filterCountries()" placeholder="Filter Countries">
  <div *ngIf="filteredCountries.length === 0 && filterText.length > 0" data-test-id="no-result">No Results Found</div>
  <ul *ngIf="filteredCountries.length > 0" data-test-id="countryList">
    <li *ngFor="let country of filteredCountries">{{country}}</li>
</ul>
</div>
  `,
  styles:[`
    .container {
    max-width: 400px;
    margin: 0 auto;
    padding: 20px;
    background-color: #f5f5f5;
    border-radius: 5px;
    box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
  }

h2{
    font-size: 24px;
    margin-bottom: 10px;
}

.filter-input{
    width: 100%;
    padding: 10px;
    font-size: 16px;
    border: 1px solid #ccc;
    border-radius: 4px;
    margin-bottom: 10px;
}

.no-result{
    color:red;
    font-size: 16px;
    font-weight: bold;
    margin-top: 10px;
}

.country-list{
    list-style: none;
    padding: 0;
    margin: 0;
}

.country-item{
    font-size: 16px;
    padding: 5px;
    border-bottom: 1px solid #ccc;
}
  `]
})
export class CountryFilterComponent {
  @Input() countryList: string[] = [];
  filteredCountries: string[] = [];
  filterText: string = '';

  filterCountries(){
    this.filteredCountries = this.countryList.filter(country =>
      country.toLowerCase().includes(this.filterText.toLowerCase())
      );
  }
}
