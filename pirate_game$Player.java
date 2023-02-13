/*     */ public class Player
/*     */ {
/*     */   float x;
/*     */   float y;
/*     */   float z;
/*     */   float orientation;
/*     */   float cameraAng;
/*     */   float cannonTimer;
/* 639 */   float speed = 0.8F;
/*     */   public boolean w;
/*     */   public boolean s;
/*     */   
/*     */   public Player(float paramFloat1, float paramFloat2, float paramFloat3) {
/* 644 */     this.x = paramFloat1;
/* 645 */     this.z = paramFloat2;
/* 646 */     this.orientation = paramFloat3;
/* 647 */     this.cameraAng = paramFloat3 + 1.5707964F;
/*     */   }
/*     */   public boolean a; public boolean d; public boolean space;
/*     */   
/*     */   public void setCamera() {
/* 652 */     pirate_game.this.pg.camera(this.x - pirate_game.sin(this.cameraAng) * 30.0F, -12.0F, this.z - pirate_game.cos(this.cameraAng) * 30.0F, 
/* 653 */         this.x, -12.0F, this.z, 
/* 654 */         0.0F, 1.0F, 0.0F);
/*     */   }
/*     */ 
/*     */   
/*     */   public void update() {
/* 659 */     if (this.space && pirate_game.this.millis() - this.cannonTimer >= 1000.0F) {
/*     */       
/* 661 */       pirate_game.this.cannonballs.add(new pirate_game.Cannonball(pirate_game.this, this.x + pirate_game.cos(-this.orientation) * 3.0F, this.z + pirate_game.sin(-this.orientation) * 3.0F, pirate_game.cos(-this.orientation), pirate_game.sin(-this.orientation), false));
/* 662 */       this.cannonTimer = pirate_game.this.millis();
/*     */     } 
/*     */     
/* 665 */     pirate_game.this.pg.pushMatrix();
/* 666 */     pirate_game.this.pg.rotateY(this.orientation);
/* 667 */     for (pirate_game.Cannonball cannonball : pirate_game.this.cannonballs) {
/* 668 */       if (cannonball.pirateBall && !cannonball.hitPlayer && 
/* 669 */         pirate_game.abs(cannonball.x - this.x) < 4.2831855F && pirate_game.abs(cannonball.z - this.z) < 2.1415927F) {
/*     */         
/* 671 */         pirate_game.this.lives--;
/* 672 */         cannonball.hitPlayer = true;
/*     */       } 
/* 674 */     }  pirate_game.this.pg.popMatrix();
/*     */     
/* 676 */     this.y = (pirate_game.sin(pirate_game.this.millis() / 235.61946F) - 2.0F) / 4.0F;
/*     */     
/* 678 */     if (this.w)
/*     */     {
/* 680 */       if (pirate_game.abs(this.z + pirate_game.sin(-this.orientation) * this.speed) < 995.0F && pirate_game.abs(this.x + pirate_game.cos(-this.orientation) * this.speed) < 995.0F) {
/*     */         
/* 682 */         this.z += pirate_game.sin(-this.orientation) * this.speed;
/* 683 */         this.x += pirate_game.cos(-this.orientation) * this.speed;
/*     */       } 
/*     */     }
/* 686 */     if (this.s)
/*     */     {
/* 688 */       if (pirate_game.abs(this.z - pirate_game.sin(-this.orientation) * this.speed) < 995.0F && pirate_game.abs(this.x - pirate_game.cos(-this.orientation) * this.speed) < 995.0F) {
/*     */         
/* 690 */         this.z -= pirate_game.sin(-this.orientation) * this.speed;
/* 691 */         this.x -= pirate_game.cos(-this.orientation) * this.speed;
/*     */       } 
/*     */     }
/* 694 */     if (this.a)
/* 695 */       this.orientation += 0.02F; 
/* 696 */     if (this.d) {
/* 697 */       this.orientation -= 0.02F;
/*     */     }
/*     */   }
/*     */   
/*     */   public void draw() {
/* 702 */     pirate_game.this.pg.pushMatrix();
/*     */     
/* 704 */     pirate_game.this.pg.translate(this.x, this.y, this.z);
/* 705 */     pirate_game.this.pg.rotateY(this.orientation);
/*     */     
/* 707 */     pirate_game.this.pg.fill(139.0F, 69.0F, 19.0F);
/* 708 */     pirate_game.this.pg.beginShape(16); float f;
/* 709 */     for (f = -6.2831855F; f < 6.2831855F; f += 1.0471976F) {
/* 710 */       for (float f1 = -6.2831855F; f1 < 6.2831855F; f1 += 1.0471976F) {
/*     */         
/* 712 */         pirate_game.this.pg.vertex(f, -pirate_game.min((pirate_game.pow(pirate_game.abs(f), 3.0F) * 1.2F + pirate_game.pow(pirate_game.abs(f1), 6.0F) / 200.0F) / 100.0F, 3.0F), f1 / 2.0F);
/* 713 */         pirate_game.this.pg.vertex(f + 1.0471976F, -pirate_game.min((pirate_game.pow(pirate_game.abs(f + 1.0471976F), 3.0F) * 1.2F + pirate_game.pow(pirate_game.abs(f1), 6.0F) / 200.0F) / 100.0F, 3.0F), f1 / 2.0F);
/* 714 */         pirate_game.this.pg.vertex(f + 1.0471976F, -pirate_game.min((pirate_game.pow(pirate_game.abs(f + 1.0471976F), 3.0F) * 1.2F + pirate_game.pow(pirate_game.abs(f1 + 1.0471976F), 6.0F) / 200.0F) / 100.0F, 3.0F), (f1 + 1.0471976F) / 2.0F);
/* 715 */         pirate_game.this.pg.vertex(f, -pirate_game.min((pirate_game.pow(pirate_game.abs(f), 3.0F) * 1.2F + pirate_game.pow(pirate_game.abs(f1 + 1.0471976F), 6.0F) / 200.0F) / 100.0F, 3.0F), (f1 + 1.0471976F) / 2.0F);
/*     */       } 
/* 717 */     }  pirate_game.this.pg.endShape();
/*     */     
/* 719 */     pirate_game.this.pg.translate(-2.0F, 0.0F, 0.0F);
/*     */     
/* 721 */     pirate_game.this.pg.fill(139.0F, 69.0F, 19.0F);
/* 722 */     pirate_game.this.pg.beginShape(16);
/* 723 */     for (f = 0.0F; f < 6.2831855F; f += 0.3926991F) {
/*     */       
/* 725 */       pirate_game.this.pg.vertex(pirate_game.cos(f) * 0.5F, -0.2F, pirate_game.sin(f) * 0.5F);
/* 726 */       pirate_game.this.pg.vertex(pirate_game.cos(f + 0.3926991F) * 0.5F, -0.2F, pirate_game.sin(f + 0.3926991F) * 0.5F);
/* 727 */       pirate_game.this.pg.vertex(pirate_game.cos(f + 0.3926991F) * 0.5F, -10.0F, pirate_game.sin(f + 0.3926991F) * 0.5F);
/* 728 */       pirate_game.this.pg.vertex(pirate_game.cos(f) * 0.5F, -10.0F, pirate_game.sin(f) * 0.5F);
/*     */     } 
/* 730 */     pirate_game.this.pg.endShape();
/*     */     
/* 732 */     pirate_game.this.pg.fill(255);
/* 733 */     pirate_game.this.pg.beginShape(16);
/* 734 */     pirate_game.this.pg.vertex(0.0F, -3.5F, -4.712389F);
/* 735 */     pirate_game.this.pg.vertex(0.0F, -3.5F, 4.712389F);
/* 736 */     pirate_game.this.pg.vertex(0.0F, -10.0F, 1.8849558F);
/* 737 */     pirate_game.this.pg.vertex(0.0F, -10.0F, -1.8849558F);
/* 738 */     pirate_game.this.pg.endShape();
/* 739 */     pirate_game.this.pg.fill(0);
/* 740 */     pirate_game.this.pg.beginShape(9);
/* 741 */     pirate_game.this.pg.vertex(0.0F, -9.9F, -0.31415927F);
/* 742 */     pirate_game.this.pg.vertex(0.0F, -10.7F, 2.5132742F);
/* 743 */     pirate_game.this.pg.vertex(0.0F, -11.5F, -0.31415927F);
/* 744 */     pirate_game.this.pg.endShape();
/*     */     
/* 746 */     pirate_game.this.pg.translate(4.0F, 0.0F, 0.0F);
/*     */     
/* 748 */     pirate_game.this.pg.fill(139.0F, 69.0F, 19.0F);
/* 749 */     pirate_game.this.pg.beginShape(16);
/* 750 */     for (f = 0.0F; f < 6.2831855F; f += 0.3926991F) {
/*     */       
/* 752 */       pirate_game.this.pg.vertex(pirate_game.cos(f) * 0.5F, -0.2F, pirate_game.sin(f) * 0.5F);
/* 753 */       pirate_game.this.pg.vertex(pirate_game.cos(f + 0.3926991F) * 0.5F, -0.2F, pirate_game.sin(f + 0.3926991F) * 0.5F);
/* 754 */       pirate_game.this.pg.vertex(pirate_game.cos(f + 0.3926991F) * 0.5F, -8.0F, pirate_game.sin(f + 0.3926991F) * 0.5F);
/* 755 */       pirate_game.this.pg.vertex(pirate_game.cos(f) * 0.5F, -8.0F, pirate_game.sin(f) * 0.5F);
/*     */     } 
/* 757 */     pirate_game.this.pg.endShape();
/*     */     
/* 759 */     pirate_game.this.pg.fill(255);
/* 760 */     pirate_game.this.pg.beginShape(16);
/* 761 */     pirate_game.this.pg.vertex(0.0F, -3.5F, -3.1415927F);
/* 762 */     pirate_game.this.pg.vertex(0.0F, -3.5F, 3.1415927F);
/* 763 */     pirate_game.this.pg.vertex(0.0F, -8.0F, 1.2566371F);
/* 764 */     pirate_game.this.pg.vertex(0.0F, -8.0F, -1.2566371F);
/* 765 */     pirate_game.this.pg.endShape();
/*     */     
/* 767 */     pirate_game.this.pg.translate(2.0F, -2.5F, 0.0F);
/*     */     
/* 769 */     pirate_game.this.pg.fill(90.0F, 45.0F, 10.0F);
/* 770 */     pirate_game.this.pg.box(2.0F);
/*     */     
/* 772 */     pirate_game.this.pg.rotateZ(-0.3926991F);
/* 773 */     pirate_game.this.pg.fill(0);
/* 774 */     pirate_game.this.pg.beginShape(16);
/* 775 */     for (f = 0.0F; f < 6.2831855F; f += 0.3926991F) {
/*     */       
/* 777 */       pirate_game.this.pg.vertex(0.0F, pirate_game.cos(f) * 0.5F, pirate_game.sin(f) * 0.5F);
/* 778 */       pirate_game.this.pg.vertex(0.0F, pirate_game.cos(f + 0.3926991F) * 0.5F, pirate_game.sin(f + 0.3926991F) * 0.5F);
/* 779 */       pirate_game.this.pg.vertex(3.0F, pirate_game.cos(f + 0.3926991F) * 0.5F, pirate_game.sin(f + 0.3926991F) * 0.5F);
/* 780 */       pirate_game.this.pg.vertex(3.0F, pirate_game.cos(f) * 0.5F, pirate_game.sin(f) * 0.5F);
/*     */     } 
/* 782 */     pirate_game.this.pg.endShape();
/*     */     
/* 784 */     pirate_game.this.pg.popMatrix();
/*     */   }
/*     */ }
