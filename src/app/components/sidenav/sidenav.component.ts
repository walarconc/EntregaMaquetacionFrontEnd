import { Component } from '@angular/core';

@Component({
  selector: 'app-sidenav',
  templateUrl: './sidenav.component.html',
  styleUrls: ['./sidenav.component.scss']
})
export class SidenavComponent {
  selectedButtonIndex = 0;

  selectButton(index: number) {
    this.selectedButtonIndex = index;
  }
}
