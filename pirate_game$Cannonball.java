/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class Cannonball
/*     */ {
/*     */   float x;
/*     */   float y;
/*     */   float z;
/*     */   float xVel;
/*     */   float zVel;
/* 213 */   float speed = 1.8F; float x0; float range = 120.0F; float z0;
/*     */   boolean pirateBall;
/*     */   boolean hitPlayer;
/*     */   
/*     */   public Cannonball(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, boolean paramBoolean) {
/* 218 */     float f = pirate_game.mag(paramFloat3, paramFloat4);
/* 219 */     this.x = paramFloat1;
/* 220 */     this.z = paramFloat2;
/* 221 */     this.xVel = paramFloat3 / f;
/* 222 */     this.zVel = paramFloat4 / f;
/* 223 */     this.x0 = paramFloat1;
/* 224 */     this.z0 = paramFloat2;
/* 225 */     this.pirateBall = paramBoolean;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean update() {
/* 230 */     if (this.hitPlayer) {
/*     */       
/* 232 */       pirate_game.this.explosions.add(new pirate_game.Explosion(pirate_game.this, this.x, this.z, true));
/* 233 */       return true;
/*     */     } 
/*     */     
/* 236 */     this.x += this.xVel * this.speed;
/* 237 */     this.z += this.zVel * this.speed;
/* 238 */     this.y = -(3.0F + 3.1F * pirate_game.sin(pirate_game.mag(this.x - this.x0, this.z - this.z0) / this.range / 3.1415927F));
/* 239 */     if (this.y > 0.0F)
/* 240 */       return true; 
/* 241 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void draw() {
/* 246 */     pirate_game.this.pg.pushMatrix();
/* 247 */     pirate_game.this.pg.translate(this.x, this.y, this.z);
/* 248 */     pirate_game.this.pg.fill(0);
/* 249 */     pirate_game.this.pg.sphere(0.6F);
/* 250 */     pirate_game.this.pg.popMatrix();
/*     */   }
/*     */ }


/* Location:              C:\Users\nicho\Downloads\PirateGame.zip!\lib\pirate_game.jar!\pirate_game$Cannonball.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */