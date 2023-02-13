/*     */ public class Explosion
/*     */ {
/*     */   float x;
/*     */   float z;
/*     */   float timer;
/*     */   float t;
/*     */   boolean playerHit;
/*     */   
/*     */   public Explosion(float paramFloat1, float paramFloat2, boolean paramBoolean) {
/* 261 */     this.x = paramFloat1; this.z = paramFloat2; this.timer = parampirate_game.millis(); this.playerHit = paramBoolean;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean update() {
/* 266 */     if (pirate_game.this.millis() - this.timer > 1050.0F)
/* 267 */       return true; 
/* 268 */     this.t = (pirate_game.this.millis() - this.timer) / 70.0F;
/* 269 */     if (this.playerHit)
/* 270 */       this.t *= 0.15F; 
/* 271 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void draw() {
/* 276 */     pirate_game.this.pg.fill(139.0F, 69.0F, 19.0F);
/* 277 */     for (float f = 0.0F; f < 6.2831855F; f += 0.3926991F) {
/* 278 */       for (float f1 = 0.0F; f1 < 6.2831855F; f1 += 0.3926991F) {
/*     */         
/* 280 */         pirate_game.this.pg.pushMatrix();
/* 281 */         pirate_game.this.pg.translate(this.t * pirate_game.cos(f) * pirate_game.cos(f1) + this.x, this.t * pirate_game.sin(f) - 5.0F, this.t * pirate_game.cos(f) * pirate_game.sin(f1) + this.z);
/* 282 */         if (this.playerHit) {
/* 283 */           pirate_game.this.pg.box(0.4F);
/*     */         } else {
/* 285 */           pirate_game.this.pg.box(1.0F);
/* 286 */         }  pirate_game.this.pg.popMatrix();
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }
