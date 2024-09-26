import { Component, Input, Output, EventEmitter } from '@angular/core';

@Component({
  selector: 'app-star-rating',
  templateUrl: './star-rating.component.html',
  styleUrls: ['./star-rating.component.css']
})
export class StarRatingComponent {
  @Input() rating: number = 0;
  @Output() ratingChange: EventEmitter<number> = new EventEmitter<number>();

  hoverRating: number = 0;

  rate(rating: number): void {
    this.rating = rating;
    this.ratingChange.emit(this.rating);
  }

  hover(rating: number): void {
    this.hoverRating = rating;
  }

  getStarIcon(index: number): string {
    if (this.hoverRating >= index + 1 || this.rating >= index + 1) {
      return 'star';
    }
    return 'star_outline';
  }
}
