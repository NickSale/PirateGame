/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class MerchantShip
/*     */ {
/*     */   float x;
/*     */   float y;
/*     */   float z;
/*     */   float orientation;
/*     */   float o0;
/* 341 */   float speed = 0.3F;
/*     */   float money;
/*     */   boolean run;
/*     */   
/*     */   public MerchantShip(float paramFloat1, float paramFloat2, float paramFloat3) {
/* 346 */     this.x = paramFloat1;
/* 347 */     this.z = paramFloat2;
/* 348 */     this.o0 = paramFloat3;
/* 349 */     this.money = parampirate_game.random(50.0F, 250.0F);
/* 350 */     parampirate_game.currentShips++;
/* 351 */     if (parampirate_game.random(2.0F) <= 1.0F) {
/* 352 */       this.run = true;
/*     */     }
/*     */   }
/*     */   
/*     */   public boolean update() {
/* 357 */     float f = 0.0F;
/* 358 */     if (this.run) {
/*     */       
/* 360 */       if (pirate_game.mag(pirate_game.this.player.x - this.x, pirate_game.this.player.z - this.z) < 100.0F) {
/* 361 */         f = -pirate_game.atan2(this.x - pirate_game.this.player.x, pirate_game.this.player.z - this.z) + 1.5707964F;
/*     */       } else {
/* 363 */         f = this.o0;
/* 364 */       }  this.orientation %= 6.2831855F;
/* 365 */       if (this.orientation < 0.0F)
/* 366 */         this.orientation += 6.2831855F; 
/* 367 */       f %= 6.2831855F;
/* 368 */       if (f < 0.0F)
/* 369 */         f += 6.2831855F; 
/* 370 */       float f1 = f - this.orientation;
/* 371 */       if ((f1 <= 3.1415927F && f1 > 0.1F) || (f1 < 0.0F && -f1 >= 3.1415927F)) {
/* 372 */         this.orientation += 0.02F;
/* 373 */       } else if (f1 > 3.1415927F || (f1 < -0.1F && -f1 < 3.1415927F)) {
/* 374 */         this.orientation -= 0.02F;
/*     */       } 
/*     */     } 
/* 377 */     this.x += pirate_game.cos(-this.orientation) * this.speed;
/* 378 */     this.z += pirate_game.sin(-this.orientation) * this.speed;
/*     */     
/* 380 */     if (pirate_game.abs(this.x) >= 995.0F || pirate_game.abs(this.z) >= 995.0F) {
/*     */       
/* 382 */       this.x -= pirate_game.cos(-this.orientation) * 5.0F;
/* 383 */       this.z -= pirate_game.sin(-this.orientation) * 5.0F;
/* 384 */       this.o0 += 3.1415927F;
/* 385 */       this.orientation += 3.1415927F;
/*     */     } 
/*     */     
/* 388 */     this.y = (pirate_game.sin(pirate_game.this.millis() / 235.61946F) - 2.0F) / 4.0F;
/*     */     
/* 390 */     pirate_game.this.pg.pushMatrix();
/* 391 */     pirate_game.this.pg.rotateY(this.orientation);
/* 392 */     for (pirate_game.Cannonball cannonball : pirate_game.this.cannonballs) {
/* 393 */       if (!cannonball.pirateBall && 
/* 394 */         pirate_game.abs(cannonball.x - this.x) < 4.2831855F && pirate_game.abs(cannonball.z - this.z) < 2.1415927F) {
/*     */         
/* 396 */         pirate_game.this.treasure = (int)(pirate_game.this.treasure + this.money);
/* 397 */         pirate_game.this.ships++;
/* 398 */         pirate_game.this.currentShips--;
/* 399 */         pirate_game.this.explosions.add(new pirate_game.Explosion(pirate_game.this, this.x, this.z, false));
/* 400 */         pirate_game.this.pg.popMatrix();
/* 401 */         return true;
/*     */       } 
/* 403 */     }  pirate_game.this.pg.popMatrix();
/* 404 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void draw() {
/* 409 */     pirate_game.this.pg.pushMatrix();
/*     */     
/* 411 */     pirate_game.this.pg.translate(this.x, this.y, this.z);
/* 412 */     pirate_game.this.pg.rotateY(this.orientation);
/*     */     
/* 414 */     pirate_game.this.pg.fill(139.0F, 69.0F, 19.0F);
/* 415 */     pirate_game.this.pg.beginShape(16); float f;
/* 416 */     for (f = -6.2831855F; f < 6.2831855F; f += 1.5707964F) {
/* 417 */       for (float f1 = -6.2831855F; f1 < 6.2831855F; f1 += 1.5707964F) {
/*     */         
/* 419 */         pirate_game.this.pg.vertex(f, -pirate_game.min((pirate_game.pow(pirate_game.abs(f), 3.0F) * 1.2F + pirate_game.pow(pirate_game.abs(f1), 6.0F) / 200.0F) / 100.0F, 3.0F), f1 / 2.0F);
/* 420 */         pirate_game.this.pg.vertex(f + 1.5707964F, -pirate_game.min((pirate_game.pow(pirate_game.abs(f + 1.5707964F), 3.0F) * 1.2F + pirate_game.pow(pirate_game.abs(f1), 6.0F) / 200.0F) / 100.0F, 3.0F), f1 / 2.0F);
/* 421 */         pirate_game.this.pg.vertex(f + 1.5707964F, -pirate_game.min((pirate_game.pow(pirate_game.abs(f + 1.5707964F), 3.0F) * 1.2F + pirate_game.pow(pirate_game.abs(f1 + 1.5707964F), 6.0F) / 200.0F) / 100.0F, 3.0F), (f1 + 1.5707964F) / 2.0F);
/* 422 */         pirate_game.this.pg.vertex(f, -pirate_game.min((pirate_game.pow(pirate_game.abs(f), 3.0F) * 1.2F + pirate_game.pow(pirate_game.abs(f1 + 1.5707964F), 6.0F) / 200.0F) / 100.0F, 3.0F), (f1 + 1.5707964F) / 2.0F);
/*     */       } 
/* 424 */     }  pirate_game.this.pg.endShape();
/*     */     
/* 426 */     pirate_game.this.pg.translate(-2.0F, 0.0F, 0.0F);
/*     */     
/* 428 */     pirate_game.this.pg.fill(139.0F, 69.0F, 19.0F);
/* 429 */     pirate_game.this.pg.beginShape(16);
/* 430 */     for (f = 0.0F; f < 6.2831855F; f += 1.0471976F) {
/*     */       
/* 432 */       pirate_game.this.pg.vertex(pirate_game.cos(f) * 0.5F, -0.2F, pirate_game.sin(f) * 0.5F);
/* 433 */       pirate_game.this.pg.vertex(pirate_game.cos(f + 1.0471976F) * 0.5F, -0.2F, pirate_game.sin(f + 1.0471976F) * 0.5F);
/* 434 */       pirate_game.this.pg.vertex(pirate_game.cos(f + 1.0471976F) * 0.5F, -10.0F, pirate_game.sin(f + 1.0471976F) * 0.5F);
/* 435 */       pirate_game.this.pg.vertex(pirate_game.cos(f) * 0.5F, -10.0F, pirate_game.sin(f) * 0.5F);
/*     */     } 
/* 437 */     pirate_game.this.pg.endShape();
/*     */     
/* 439 */     pirate_game.this.pg.fill(255);
/* 440 */     pirate_game.this.pg.beginShape(16);
/* 441 */     pirate_game.this.pg.vertex(0.0F, -3.5F, -4.712389F);
/* 442 */     pirate_game.this.pg.vertex(0.0F, -3.5F, 4.712389F);
/* 443 */     pirate_game.this.pg.vertex(0.0F, -10.0F, 1.8849558F);
/* 444 */     pirate_game.this.pg.vertex(0.0F, -10.0F, -1.8849558F);
/* 445 */     pirate_game.this.pg.endShape();
/* 446 */     pirate_game.this.pg.fill(90.0F, 90.0F, 240.0F);
/* 447 */     pirate_game.this.pg.beginShape(9);
/* 448 */     pirate_game.this.pg.vertex(0.0F, -9.9F, -0.31415927F);
/* 449 */     pirate_game.this.pg.vertex(0.0F, -10.7F, 2.5132742F);
/* 450 */     pirate_game.this.pg.vertex(0.0F, -11.5F, -0.31415927F);
/* 451 */     pirate_game.this.pg.endShape();
/*     */     
/* 453 */     pirate_game.this.pg.translate(4.0F, 0.0F, 0.0F);
/*     */     
/* 455 */     pirate_game.this.pg.fill(139.0F, 69.0F, 19.0F);
/* 456 */     pirate_game.this.pg.beginShape(16);
/* 457 */     for (f = 0.0F; f < 6.2831855F; f += 1.5707964F) {
/*     */       
/* 459 */       pirate_game.this.pg.vertex(pirate_game.cos(f) * 0.5F, -0.2F, pirate_game.sin(f) * 0.5F);
/* 460 */       pirate_game.this.pg.vertex(pirate_game.cos(f + 1.5707964F) * 0.5F, -0.2F, pirate_game.sin(f + 1.5707964F) * 0.5F);
/* 461 */       pirate_game.this.pg.vertex(pirate_game.cos(f + 1.5707964F) * 0.5F, -8.0F, pirate_game.sin(f + 1.5707964F) * 0.5F);
/* 462 */       pirate_game.this.pg.vertex(pirate_game.cos(f) * 0.5F, -8.0F, pirate_game.sin(f) * 0.5F);
/*     */     } 
/* 464 */     pirate_game.this.pg.endShape();
/*     */     
/* 466 */     pirate_game.this.pg.fill(255);
/* 467 */     pirate_game.this.pg.beginShape(16);
/* 468 */     pirate_game.this.pg.vertex(0.0F, -3.5F, -3.1415927F);
/* 469 */     pirate_game.this.pg.vertex(0.0F, -3.5F, 3.1415927F);
/* 470 */     pirate_game.this.pg.vertex(0.0F, -8.0F, 1.2566371F);
/* 471 */     pirate_game.this.pg.vertex(0.0F, -8.0F, -1.2566371F);
/* 472 */     pirate_game.this.pg.endShape();
/*     */     
/* 474 */     pirate_game.this.pg.popMatrix();
/*     */   }
/*     */ }


/* Location:              C:\Users\nicho\Downloads\PirateGame.zip!\lib\pirate_game.jar!\pirate_game$MerchantShip.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */