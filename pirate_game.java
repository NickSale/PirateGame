/*     */ import java.awt.AWTException;
/*     */ import java.awt.Robot;
/*     */ import java.util.ArrayList;
/*     */ import processing.core.PApplet;
/*     */ import processing.core.PFont;
/*     */ import processing.core.PGraphics;
/*     */ import processing.core.PImage;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class pirate_game
/*     */   extends PApplet
/*     */ {
/*     */   Player player;
/*     */   Robot robot;
/*  28 */   ArrayList<Cannonball> cannonballs = new ArrayList<Cannonball>();
/*  29 */   ArrayList<MerchantShip> merchants = new ArrayList<MerchantShip>();
/*  30 */   ArrayList<PirateShip> pirates = new ArrayList<PirateShip>();
/*  31 */   ArrayList<Explosion> explosions = new ArrayList<Explosion>();
/*  32 */   int treasure = 0; int ships = 0; int lives = 3; int currentShips = 0; int maxShips = 25; PFont font; PImage coin; PImage boat; PImage livesImage;
/*     */   PGraphics pg;
/*     */   boolean paused;
/*     */   boolean gameOver;
/*     */   boolean pHeld;
/*     */   float seaAnim;
/*     */   
/*     */   public void setup() {
/*  40 */     size(800, 800);
/*  41 */     frameRate(60.0F);
/*     */ 
/*     */     
/*     */     try {
/*  45 */       this.robot = new Robot();
/*     */     }
/*  47 */     catch (AWTException aWTException) {
/*     */       
/*  49 */       aWTException.printStackTrace();
/*     */     } 
/*     */     
/*  52 */     this.robot.mouseMove(this.screenWidth / 2, this.screenHeight / 2);
/*  53 */     this.player = new Player(950.0F, 950.0F, 2.3561945F);
/*  54 */     this.pg = createGraphics(this.width, this.height, "processing.core.PGraphics3D");
/*  55 */     this.font = loadFont("font.vlw");
/*  56 */     this.coin = loadImage("coin.png");
/*  57 */     this.boat = loadImage("boat.png");
/*  58 */     this.livesImage = loadImage("lives.png");
/*  59 */     for (byte b = 0; b < this.maxShips; b++) {
/*     */       
/*  61 */       if (random(2.0F) <= 1.0F) {
/*  62 */         this.merchants.add(new MerchantShip(random(-900.0F, 900.0F), random(-900.0F, 900.0F), random(0.0F, 6.2831855F)));
/*     */       } else {
/*  64 */         this.pirates.add(new PirateShip(random(-900.0F, 900.0F), random(-900.0F, 900.0F), random(0.0F, 6.2831855F)));
/*     */       } 
/*  66 */     }  this.merchants.add(new MerchantShip(950.0F, 80.0F, 3.1415927F));
/*     */   }
/*     */ 
/*     */   
/*     */   public void update() {
/*  71 */     if (this.lives == 0) {
/*     */       
/*  73 */       this.gameOver = true;
/*  74 */       this.paused = true;
/*     */     } 
/*     */     
/*  77 */     if (this.paused)
/*     */     {
/*  79 */       cursor();
/*     */     }
/*     */     
/*  82 */     if (this.gameOver && this.player.space) {
/*     */       
/*  84 */       this.treasure = 0;
/*  85 */       this.ships = 0;
/*  86 */       this.lives = 3;
/*  87 */       this.merchants = new ArrayList<MerchantShip>();
/*  88 */       this.pirates = new ArrayList<PirateShip>();
/*  89 */       this.cannonballs = new ArrayList<Cannonball>();
/*  90 */       this.explosions = new ArrayList<Explosion>();
/*  91 */       this.currentShips = 0;
/*  92 */       for (byte b = 0; b < this.maxShips; b++) {
/*     */         
/*  94 */         if (random(2.0F) <= 1.0F) {
/*  95 */           this.merchants.add(new MerchantShip(random(-900.0F, 900.0F), random(-900.0F, 900.0F), random(0.0F, 6.2831855F)));
/*     */         } else {
/*  97 */           this.pirates.add(new PirateShip(random(-900.0F, 900.0F), random(-900.0F, 900.0F), random(0.0F, 6.2831855F)));
/*     */         } 
/*  99 */       }  this.player = new Player(950.0F, 950.0F, 2.3561945F);
/* 100 */       this.paused = false; this.gameOver = false;
/*     */     } 
/*     */     
/* 103 */     if (!this.paused) {
/*     */       
/* 105 */       noCursor();
/*     */       
/* 107 */       while (this.currentShips < this.maxShips) {
/*     */         float f1, f2;
/*     */         
/* 110 */         if (random(2.0F) <= 1.0F) {
/* 111 */           f1 = random(-900.0F, max(this.player.x - 200.0F, -850.0F));
/*     */         } else {
/* 113 */           f1 = random(min(this.player.x + 200.0F, 850.0F), 900.0F);
/* 114 */         }  if (random(2.0F) <= 1.0F) {
/* 115 */           f2 = random(-900.0F, max(this.player.z - 200.0F, -850.0F));
/*     */         } else {
/* 117 */           f2 = random(min(this.player.z + 200.0F, 850.0F), 900.0F);
/*     */         } 
/* 119 */         if (random(2.0F) <= 1.0F) {
/* 120 */           this.merchants.add(new MerchantShip(f1, f2, random(0.0F, 6.2831855F))); continue;
/*     */         } 
/* 122 */         this.pirates.add(new PirateShip(f1, f2, random(0.0F, 6.2831855F)));
/*     */       } 
/*     */       
/* 125 */       this.player.update(); byte b;
/* 126 */       for (b = 0; b < this.cannonballs.size(); b++) {
/* 127 */         if (((Cannonball)this.cannonballs.get(b)).update())
/* 128 */           this.cannonballs.remove(b); 
/* 129 */       }  for (b = 0; b < this.merchants.size(); b++) {
/* 130 */         if (((MerchantShip)this.merchants.get(b)).update())
/* 131 */           this.merchants.remove(b); 
/* 132 */       }  for (b = 0; b < this.pirates.size(); b++) {
/* 133 */         if (((PirateShip)this.pirates.get(b)).update())
/* 134 */           this.pirates.remove(b); 
/*     */       } 
/*     */     } 
/* 137 */     if (!this.paused || this.gameOver)
/*     */     {
/* 139 */       for (byte b = 0; b < this.explosions.size(); b++) {
/* 140 */         if (((Explosion)this.explosions.get(b)).update())
/* 141 */           this.explosions.remove(b); 
/*     */       } 
/*     */     }
/*     */   }
/*     */   
/*     */   public void draw() {
/* 147 */     update();
/*     */     
/* 149 */     this.pg.beginDraw();
/* 150 */     this.pg.noStroke();
/* 151 */     this.pg.lights();
/* 152 */     this.pg.directionalLight(230.0F, 230.0F, 190.0F, 1.0F, 2.0F, 1.0F);
/* 153 */     this.player.setCamera();
/* 154 */     this.pg.background(170.0F, 200.0F, 250.0F);
/*     */     
/* 156 */     drawSea();
/* 157 */     drawFence();
/* 158 */     this.player.draw();
/* 159 */     for (Cannonball cannonball : this.cannonballs)
/* 160 */       cannonball.draw(); 
/* 161 */     for (MerchantShip merchantShip : this.merchants) {
/* 162 */       if (sin(this.player.cameraAng) * (merchantShip.x - this.player.x + sin(this.player.cameraAng) * 30.0F) + 
/* 163 */         cos(this.player.cameraAng) * (merchantShip.z - this.player.z + cos(this.player.cameraAng) * 30.0F) > 0.0F)
/* 164 */         merchantShip.draw(); 
/* 165 */     }  for (PirateShip pirateShip : this.pirates) {
/* 166 */       if (sin(this.player.cameraAng) * (pirateShip.x - this.player.x + sin(this.player.cameraAng) * 30.0F) + 
/* 167 */         cos(this.player.cameraAng) * (pirateShip.z - this.player.z + cos(this.player.cameraAng) * 30.0F) > 0.0F)
/* 168 */         pirateShip.draw(); 
/* 169 */     }  for (Explosion explosion : this.explosions) {
/* 170 */       if (sin(this.player.cameraAng) * (explosion.x - this.player.x + sin(this.player.cameraAng) * 30.0F) + 
/* 171 */         cos(this.player.cameraAng) * (explosion.z - this.player.z + cos(this.player.cameraAng) * 30.0F) > 0.0F)
/* 172 */         explosion.draw(); 
/* 173 */     }  this.pg.endDraw();
/*     */     
/* 175 */     image((PImage)this.pg, 0.0F, 0.0F);
/*     */     
/* 177 */     fill(40.0F, 40.0F, 220.0F);
/* 178 */     rect(0.0F, 0.0F, this.width, this.height / 5.55F);
/*     */     
/* 180 */     fill(0);
/* 181 */     textFont(this.font, this.height / 27.7F);
/* 182 */     image(this.coin, (this.width / 50), (this.height / 50), this.width / 14.25F, this.height / 14.25F);
/* 183 */     text("Treasure:", (this.width / 10), this.height / 38.45F, this.width / 3.33F, this.height / 9.09F);
/* 184 */     text(str(this.treasure), this.width / 3.03F, this.height / 38.45F, this.width / 3.33F, this.height / 9.09F);
/* 185 */     image(this.boat, this.width / 1.67F, this.height / 166.67F, (this.width / 10), (this.height / 10));
/* 186 */     text("Ships:", this.width / 1.41F, this.height / 38.45F, this.width / 3.33F, this.height / 9.09F);
/* 187 */     text(str(this.ships), this.width / 1.16F, this.height / 38.45F, this.width / 3.33F, this.height / 9.09F);
/* 188 */     image(this.livesImage, this.width / 3.03F, this.height / 12.5F, (this.width / 10), (this.height / 10));
/* 189 */     text("Lives:", this.width / 2.27F, (this.height / 10), this.width / 3.33F, this.height / 9.09F);
/* 190 */     text(str(this.lives), this.width / 1.72F, (this.height / 10), this.width / 3.33F, this.height / 9.09F);
/*     */     
/* 192 */     textFont(this.font, (this.height / 40));
/* 193 */     text("By Nick Sale", (this.width / 100), (this.height / 7), this.width / 3.33F, this.height / 9.09F);
/*     */     
/* 195 */     if (this.paused) {
/*     */       
/* 197 */       textFont(this.font, (this.height / 10));
/* 198 */       if (this.gameOver) {
/*     */         
/* 200 */         text("GAME OVER", (this.width / 8), (this.height / 4), (this.width * 7 / 8), (this.height / 2));
/* 201 */         textFont(this.font, (this.height / 20));
/* 202 */         text("Press space to restart...", (this.width / 8 + 20), (this.height / 3 + 20), (this.width * 7 / 8), (this.height / 2));
/*     */       }
/*     */       else {
/*     */         
/* 206 */         text("PAUSED", (this.width / 8), (this.height / 4), (this.width * 7 / 8), (this.height / 2));
/*     */       } 
/*     */     } 
/*     */   }
/*     */   public class Cannonball { float x; float y; float z;
/*     */     float xVel;
/*     */     float zVel;
/* 213 */     float speed = 1.8F; float x0; float z0; float range = 120.0F;
/*     */     boolean pirateBall;
/*     */     boolean hitPlayer;
/*     */     
/*     */     public Cannonball(float param1Float1, float param1Float2, float param1Float3, float param1Float4, boolean param1Boolean) {
/* 218 */       float f = pirate_game.mag(param1Float3, param1Float4);
/* 219 */       this.x = param1Float1;
/* 220 */       this.z = param1Float2;
/* 221 */       this.xVel = param1Float3 / f;
/* 222 */       this.zVel = param1Float4 / f;
/* 223 */       this.x0 = param1Float1;
/* 224 */       this.z0 = param1Float2;
/* 225 */       this.pirateBall = param1Boolean;
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean update() {
/* 230 */       if (this.hitPlayer) {
/*     */         
/* 232 */         pirate_game.this.explosions.add(new pirate_game.Explosion(this.x, this.z, true));
/* 233 */         return true;
/*     */       } 
/*     */       
/* 236 */       this.x += this.xVel * this.speed;
/* 237 */       this.z += this.zVel * this.speed;
/* 238 */       this.y = -(3.0F + 3.1F * pirate_game.sin(pirate_game.mag(this.x - this.x0, this.z - this.z0) / this.range / 3.1415927F));
/* 239 */       if (this.y > 0.0F)
/* 240 */         return true; 
/* 241 */       return false;
/*     */     }
/*     */ 
/*     */     
/*     */     public void draw() {
/* 246 */       pirate_game.this.pg.pushMatrix();
/* 247 */       pirate_game.this.pg.translate(this.x, this.y, this.z);
/* 248 */       pirate_game.this.pg.fill(0);
/* 249 */       pirate_game.this.pg.sphere(0.6F);
/* 250 */       pirate_game.this.pg.popMatrix();
/*     */     } }
/*     */   
/*     */   public class Explosion {
/*     */     float x;
/*     */     float z;
/*     */     float timer;
/*     */     float t;
/*     */     boolean playerHit;
/*     */     
/*     */     public Explosion(float param1Float1, float param1Float2, boolean param1Boolean) {
/* 261 */       this.x = param1Float1; this.z = param1Float2; this.timer = pirate_game.this.millis(); this.playerHit = param1Boolean;
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean update() {
/* 266 */       if (pirate_game.this.millis() - this.timer > 1050.0F)
/* 267 */         return true; 
/* 268 */       this.t = (pirate_game.this.millis() - this.timer) / 70.0F;
/* 269 */       if (this.playerHit)
/* 270 */         this.t *= 0.15F; 
/* 271 */       return false;
/*     */     }
/*     */ 
/*     */     
/*     */     public void draw() {
/* 276 */       pirate_game.this.pg.fill(139.0F, 69.0F, 19.0F);
/* 277 */       for (float f = 0.0F; f < 6.2831855F; f += 0.3926991F) {
/* 278 */         for (float f1 = 0.0F; f1 < 6.2831855F; f1 += 0.3926991F) {
/*     */           
/* 280 */           pirate_game.this.pg.pushMatrix();
/* 281 */           pirate_game.this.pg.translate(this.t * pirate_game.cos(f) * pirate_game.cos(f1) + this.x, this.t * pirate_game.sin(f) - 5.0F, this.t * pirate_game.cos(f) * pirate_game.sin(f1) + this.z);
/* 282 */           if (this.playerHit) {
/* 283 */             pirate_game.this.pg.box(0.4F);
/*     */           } else {
/* 285 */             pirate_game.this.pg.box(1.0F);
/* 286 */           }  pirate_game.this.pg.popMatrix();
/*     */         } 
/*     */       } 
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public void keyPressed() {
/* 294 */     if (this.key == 'w' || this.key == 'W') {
/* 295 */       this.player.w = true;
/* 296 */     } else if (this.key == 's' || this.key == 'S') {
/* 297 */       this.player.s = true;
/* 298 */     } else if (this.key == 'a' || this.key == 'A') {
/* 299 */       this.player.a = true;
/* 300 */     } else if (this.key == 'd' || this.key == 'D') {
/* 301 */       this.player.d = true;
/* 302 */     } else if (this.key == ' ') {
/* 303 */       this.player.space = true;
/* 304 */     } else if ((this.key == 'p' || this.key == 'P') && !this.pHeld && !this.gameOver) {
/*     */       
/* 306 */       this.paused = !this.paused;
/* 307 */       this.pHeld = true;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void keyReleased() {
/* 313 */     if (this.key == 'w' || this.key == 'W') {
/* 314 */       this.player.w = false;
/* 315 */     } else if (this.key == 's' || this.key == 'S') {
/* 316 */       this.player.s = false;
/* 317 */     } else if (this.key == 'a' || this.key == 'A') {
/* 318 */       this.player.a = false;
/* 319 */     } else if (this.key == 'd' || this.key == 'D') {
/* 320 */       this.player.d = false;
/* 321 */     } else if (this.key == ' ') {
/* 322 */       this.player.space = false;
/* 323 */     } else if (this.key == 'p' || this.key == 'P') {
/* 324 */       this.pHeld = false;
/*     */     } 
/*     */   }
/*     */   
/*     */   public void mouseMoved() {
/* 329 */     if (!this.paused) {
/*     */       
/* 331 */       if (this.mouseX > this.width / 2) {
/* 332 */         this.player.cameraAng -= 0.01F;
/* 333 */       } else if (this.mouseX < this.width / 2) {
/* 334 */         this.player.cameraAng += 0.01F;
/* 335 */       }  this.robot.mouseMove((this.frame.getLocation()).x + this.width / 2 + 3, (this.frame.getLocation()).y + this.height / 2);
/*     */     } 
/*     */   }
/*     */   public class MerchantShip { float x; float y; float z;
/*     */     float orientation;
/*     */     float o0;
/* 341 */     float speed = 0.3F;
/*     */     float money;
/*     */     boolean run;
/*     */     
/*     */     public MerchantShip(float param1Float1, float param1Float2, float param1Float3) {
/* 346 */       this.x = param1Float1;
/* 347 */       this.z = param1Float2;
/* 348 */       this.o0 = param1Float3;
/* 349 */       this.money = pirate_game.this.random(50.0F, 250.0F);
/* 350 */       pirate_game.this.currentShips++;
/* 351 */       if (pirate_game.this.random(2.0F) <= 1.0F) {
/* 352 */         this.run = true;
/*     */       }
/*     */     }
/*     */     
/*     */     public boolean update() {
/* 357 */       float f = 0.0F;
/* 358 */       if (this.run) {
/*     */         
/* 360 */         if (pirate_game.mag(pirate_game.this.player.x - this.x, pirate_game.this.player.z - this.z) < 100.0F) {
/* 361 */           f = -pirate_game.atan2(this.x - pirate_game.this.player.x, pirate_game.this.player.z - this.z) + 1.5707964F;
/*     */         } else {
/* 363 */           f = this.o0;
/* 364 */         }  this.orientation %= 6.2831855F;
/* 365 */         if (this.orientation < 0.0F)
/* 366 */           this.orientation += 6.2831855F; 
/* 367 */         f %= 6.2831855F;
/* 368 */         if (f < 0.0F)
/* 369 */           f += 6.2831855F; 
/* 370 */         float f1 = f - this.orientation;
/* 371 */         if ((f1 <= 3.1415927F && f1 > 0.1F) || (f1 < 0.0F && -f1 >= 3.1415927F)) {
/* 372 */           this.orientation += 0.02F;
/* 373 */         } else if (f1 > 3.1415927F || (f1 < -0.1F && -f1 < 3.1415927F)) {
/* 374 */           this.orientation -= 0.02F;
/*     */         } 
/*     */       } 
/* 377 */       this.x += pirate_game.cos(-this.orientation) * this.speed;
/* 378 */       this.z += pirate_game.sin(-this.orientation) * this.speed;
/*     */       
/* 380 */       if (pirate_game.abs(this.x) >= 995.0F || pirate_game.abs(this.z) >= 995.0F) {
/*     */         
/* 382 */         this.x -= pirate_game.cos(-this.orientation) * 5.0F;
/* 383 */         this.z -= pirate_game.sin(-this.orientation) * 5.0F;
/* 384 */         this.o0 += 3.1415927F;
/* 385 */         this.orientation += 3.1415927F;
/*     */       } 
/*     */       
/* 388 */       this.y = (pirate_game.sin(pirate_game.this.millis() / 235.61946F) - 2.0F) / 4.0F;
/*     */       
/* 390 */       pirate_game.this.pg.pushMatrix();
/* 391 */       pirate_game.this.pg.rotateY(this.orientation);
/* 392 */       for (pirate_game.Cannonball cannonball : pirate_game.this.cannonballs) {
/* 393 */         if (!cannonball.pirateBall && 
/* 394 */           pirate_game.abs(cannonball.x - this.x) < 4.2831855F && pirate_game.abs(cannonball.z - this.z) < 2.1415927F) {
/*     */           
/* 396 */           pirate_game.this.treasure = (int)(pirate_game.this.treasure + this.money);
/* 397 */           pirate_game.this.ships++;
/* 398 */           pirate_game.this.currentShips--;
/* 399 */           pirate_game.this.explosions.add(new pirate_game.Explosion(this.x, this.z, false));
/* 400 */           pirate_game.this.pg.popMatrix();
/* 401 */           return true;
/*     */         } 
/* 403 */       }  pirate_game.this.pg.popMatrix();
/* 404 */       return false;
/*     */     }
/*     */ 
/*     */     
/*     */     public void draw() {
/* 409 */       pirate_game.this.pg.pushMatrix();
/*     */       
/* 411 */       pirate_game.this.pg.translate(this.x, this.y, this.z);
/* 412 */       pirate_game.this.pg.rotateY(this.orientation);
/*     */       
/* 414 */       pirate_game.this.pg.fill(139.0F, 69.0F, 19.0F);
/* 415 */       pirate_game.this.pg.beginShape(16); float f;
/* 416 */       for (f = -6.2831855F; f < 6.2831855F; f += 1.5707964F) {
/* 417 */         for (float f1 = -6.2831855F; f1 < 6.2831855F; f1 += 1.5707964F) {
/*     */           
/* 419 */           pirate_game.this.pg.vertex(f, -pirate_game.min((pirate_game.pow(pirate_game.abs(f), 3.0F) * 1.2F + pirate_game.pow(pirate_game.abs(f1), 6.0F) / 200.0F) / 100.0F, 3.0F), f1 / 2.0F);
/* 420 */           pirate_game.this.pg.vertex(f + 1.5707964F, -pirate_game.min((pirate_game.pow(pirate_game.abs(f + 1.5707964F), 3.0F) * 1.2F + pirate_game.pow(pirate_game.abs(f1), 6.0F) / 200.0F) / 100.0F, 3.0F), f1 / 2.0F);
/* 421 */           pirate_game.this.pg.vertex(f + 1.5707964F, -pirate_game.min((pirate_game.pow(pirate_game.abs(f + 1.5707964F), 3.0F) * 1.2F + pirate_game.pow(pirate_game.abs(f1 + 1.5707964F), 6.0F) / 200.0F) / 100.0F, 3.0F), (f1 + 1.5707964F) / 2.0F);
/* 422 */           pirate_game.this.pg.vertex(f, -pirate_game.min((pirate_game.pow(pirate_game.abs(f), 3.0F) * 1.2F + pirate_game.pow(pirate_game.abs(f1 + 1.5707964F), 6.0F) / 200.0F) / 100.0F, 3.0F), (f1 + 1.5707964F) / 2.0F);
/*     */         } 
/* 424 */       }  pirate_game.this.pg.endShape();
/*     */       
/* 426 */       pirate_game.this.pg.translate(-2.0F, 0.0F, 0.0F);
/*     */       
/* 428 */       pirate_game.this.pg.fill(139.0F, 69.0F, 19.0F);
/* 429 */       pirate_game.this.pg.beginShape(16);
/* 430 */       for (f = 0.0F; f < 6.2831855F; f += 1.0471976F) {
/*     */         
/* 432 */         pirate_game.this.pg.vertex(pirate_game.cos(f) * 0.5F, -0.2F, pirate_game.sin(f) * 0.5F);
/* 433 */         pirate_game.this.pg.vertex(pirate_game.cos(f + 1.0471976F) * 0.5F, -0.2F, pirate_game.sin(f + 1.0471976F) * 0.5F);
/* 434 */         pirate_game.this.pg.vertex(pirate_game.cos(f + 1.0471976F) * 0.5F, -10.0F, pirate_game.sin(f + 1.0471976F) * 0.5F);
/* 435 */         pirate_game.this.pg.vertex(pirate_game.cos(f) * 0.5F, -10.0F, pirate_game.sin(f) * 0.5F);
/*     */       } 
/* 437 */       pirate_game.this.pg.endShape();
/*     */       
/* 439 */       pirate_game.this.pg.fill(255);
/* 440 */       pirate_game.this.pg.beginShape(16);
/* 441 */       pirate_game.this.pg.vertex(0.0F, -3.5F, -4.712389F);
/* 442 */       pirate_game.this.pg.vertex(0.0F, -3.5F, 4.712389F);
/* 443 */       pirate_game.this.pg.vertex(0.0F, -10.0F, 1.8849558F);
/* 444 */       pirate_game.this.pg.vertex(0.0F, -10.0F, -1.8849558F);
/* 445 */       pirate_game.this.pg.endShape();
/* 446 */       pirate_game.this.pg.fill(90.0F, 90.0F, 240.0F);
/* 447 */       pirate_game.this.pg.beginShape(9);
/* 448 */       pirate_game.this.pg.vertex(0.0F, -9.9F, -0.31415927F);
/* 449 */       pirate_game.this.pg.vertex(0.0F, -10.7F, 2.5132742F);
/* 450 */       pirate_game.this.pg.vertex(0.0F, -11.5F, -0.31415927F);
/* 451 */       pirate_game.this.pg.endShape();
/*     */       
/* 453 */       pirate_game.this.pg.translate(4.0F, 0.0F, 0.0F);
/*     */       
/* 455 */       pirate_game.this.pg.fill(139.0F, 69.0F, 19.0F);
/* 456 */       pirate_game.this.pg.beginShape(16);
/* 457 */       for (f = 0.0F; f < 6.2831855F; f += 1.5707964F) {
/*     */         
/* 459 */         pirate_game.this.pg.vertex(pirate_game.cos(f) * 0.5F, -0.2F, pirate_game.sin(f) * 0.5F);
/* 460 */         pirate_game.this.pg.vertex(pirate_game.cos(f + 1.5707964F) * 0.5F, -0.2F, pirate_game.sin(f + 1.5707964F) * 0.5F);
/* 461 */         pirate_game.this.pg.vertex(pirate_game.cos(f + 1.5707964F) * 0.5F, -8.0F, pirate_game.sin(f + 1.5707964F) * 0.5F);
/* 462 */         pirate_game.this.pg.vertex(pirate_game.cos(f) * 0.5F, -8.0F, pirate_game.sin(f) * 0.5F);
/*     */       } 
/* 464 */       pirate_game.this.pg.endShape();
/*     */       
/* 466 */       pirate_game.this.pg.fill(255);
/* 467 */       pirate_game.this.pg.beginShape(16);
/* 468 */       pirate_game.this.pg.vertex(0.0F, -3.5F, -3.1415927F);
/* 469 */       pirate_game.this.pg.vertex(0.0F, -3.5F, 3.1415927F);
/* 470 */       pirate_game.this.pg.vertex(0.0F, -8.0F, 1.2566371F);
/* 471 */       pirate_game.this.pg.vertex(0.0F, -8.0F, -1.2566371F);
/* 472 */       pirate_game.this.pg.endShape();
/*     */       
/* 474 */       pirate_game.this.pg.popMatrix();
/*     */     } }
/*     */   public class PirateShip { float x; float y;
/*     */     float z;
/*     */     float orientation;
/*     */     float o0;
/* 480 */     float speed = 0.4F; float money;
/*     */     float cannonTimer;
/*     */     
/*     */     public PirateShip(float param1Float1, float param1Float2, float param1Float3) {
/* 484 */       this.x = param1Float1;
/* 485 */       this.z = param1Float2;
/* 486 */       this.o0 = param1Float3;
/* 487 */       this.money = pirate_game.this.random(200.0F, 500.0F);
/* 488 */       pirate_game.this.currentShips++;
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean update() {
/* 493 */       float f1 = 0.0F;
/* 494 */       if (pirate_game.mag(pirate_game.this.player.x - this.x, pirate_game.this.player.z - this.z) < 200.0F) {
/* 495 */         f1 = -pirate_game.atan2(this.x - pirate_game.this.player.x, pirate_game.this.player.z - this.z) - 1.5707964F;
/*     */       } else {
/* 497 */         f1 = this.o0;
/* 498 */       }  this.orientation %= 6.2831855F;
/* 499 */       if (this.orientation < 0.0F)
/* 500 */         this.orientation += 6.2831855F; 
/* 501 */       f1 %= 6.2831855F;
/* 502 */       if (f1 < 0.0F)
/* 503 */         f1 += 6.2831855F; 
/* 504 */       float f2 = f1 - this.orientation;
/* 505 */       if ((f2 <= 3.1415927F && f2 > 0.0F) || (f2 < 0.0F && -f2 >= 3.1415927F)) {
/* 506 */         this.orientation += 0.02F;
/* 507 */       } else if (f2 > 3.1415927F || (f2 < 0.0F && -f2 < 3.1415927F)) {
/* 508 */         this.orientation -= 0.02F;
/*     */       } 
/* 510 */       if (pirate_game.mag(pirate_game.this.player.x - this.x, pirate_game.this.player.z - this.z) > 70.0F) {
/*     */         
/* 512 */         this.x += pirate_game.cos(-this.orientation) * this.speed;
/* 513 */         this.z += pirate_game.sin(-this.orientation) * this.speed;
/*     */       } 
/*     */       
/* 516 */       if (pirate_game.mag(pirate_game.this.player.x - this.x, pirate_game.this.player.z - this.z) < 110.0F && pirate_game.this.millis() - this.cannonTimer >= 3500.0F) {
/*     */         
/* 518 */         pirate_game.this.cannonballs.add(new pirate_game.Cannonball(this.x + pirate_game.cos(-this.orientation) * 3.0F, this.z + pirate_game.sin(-this.orientation) * 3.0F, pirate_game.cos(-this.orientation), pirate_game.sin(-this.orientation), true));
/* 519 */         this.cannonTimer = pirate_game.this.millis();
/*     */       } 
/*     */       
/* 522 */       if (pirate_game.abs(this.x) >= 995.0F || pirate_game.abs(this.z) >= 995.0F) {
/*     */         
/* 524 */         this.x -= pirate_game.cos(-this.orientation) * 5.0F;
/* 525 */         this.z -= pirate_game.sin(-this.orientation) * 5.0F;
/* 526 */         this.o0 += 3.1415927F;
/* 527 */         this.orientation += 3.1415927F;
/*     */       } 
/*     */       
/* 530 */       this.y = (pirate_game.sin(pirate_game.this.millis() / 235.61946F) - 2.0F) / 4.0F;
/*     */       
/* 532 */       pirate_game.this.pg.pushMatrix();
/* 533 */       pirate_game.this.pg.rotateY(this.orientation);
/* 534 */       for (pirate_game.Cannonball cannonball : pirate_game.this.cannonballs) {
/* 535 */         if (!cannonball.pirateBall && 
/* 536 */           pirate_game.abs(cannonball.x - this.x) < 4.2831855F && pirate_game.abs(cannonball.z - this.z) < 2.1415927F) {
/*     */           
/* 538 */           pirate_game.this.treasure = (int)(pirate_game.this.treasure + this.money);
/* 539 */           pirate_game.this.ships++;
/* 540 */           pirate_game.this.currentShips--;
/* 541 */           pirate_game.this.explosions.add(new pirate_game.Explosion(this.x, this.z, false));
/* 542 */           pirate_game.this.pg.popMatrix();
/* 543 */           return true;
/*     */         } 
/* 545 */       }  pirate_game.this.pg.popMatrix();
/* 546 */       return false;
/*     */     }
/*     */ 
/*     */     
/*     */     public void draw() {
/* 551 */       pirate_game.this.pg.pushMatrix();
/*     */       
/* 553 */       pirate_game.this.pg.translate(this.x, this.y, this.z);
/* 554 */       pirate_game.this.pg.rotateY(this.orientation);
/*     */       
/* 556 */       pirate_game.this.pg.fill(139.0F, 69.0F, 19.0F);
/* 557 */       pirate_game.this.pg.beginShape(16); float f;
/* 558 */       for (f = -6.2831855F; f < 6.2831855F; f += 1.5707964F) {
/* 559 */         for (float f1 = -6.2831855F; f1 < 6.2831855F; f1 += 1.5707964F) {
/*     */           
/* 561 */           pirate_game.this.pg.vertex(f, -pirate_game.min((pirate_game.pow(pirate_game.abs(f), 3.0F) * 1.2F + pirate_game.pow(pirate_game.abs(f1), 6.0F) / 200.0F) / 100.0F, 3.0F), f1 / 2.0F);
/* 562 */           pirate_game.this.pg.vertex(f + 1.5707964F, -pirate_game.min((pirate_game.pow(pirate_game.abs(f + 1.5707964F), 3.0F) * 1.2F + pirate_game.pow(pirate_game.abs(f1), 6.0F) / 200.0F) / 100.0F, 3.0F), f1 / 2.0F);
/* 563 */           pirate_game.this.pg.vertex(f + 1.5707964F, -pirate_game.min((pirate_game.pow(pirate_game.abs(f + 1.5707964F), 3.0F) * 1.2F + pirate_game.pow(pirate_game.abs(f1 + 1.5707964F), 6.0F) / 200.0F) / 100.0F, 3.0F), (f1 + 1.5707964F) / 2.0F);
/* 564 */           pirate_game.this.pg.vertex(f, -pirate_game.min((pirate_game.pow(pirate_game.abs(f), 3.0F) * 1.2F + pirate_game.pow(pirate_game.abs(f1 + 1.5707964F), 6.0F) / 200.0F) / 100.0F, 3.0F), (f1 + 1.5707964F) / 2.0F);
/*     */         } 
/* 566 */       }  pirate_game.this.pg.endShape();
/*     */       
/* 568 */       pirate_game.this.pg.translate(-2.0F, 0.0F, 0.0F);
/*     */       
/* 570 */       pirate_game.this.pg.fill(139.0F, 69.0F, 19.0F);
/* 571 */       pirate_game.this.pg.beginShape(16);
/* 572 */       for (f = 0.0F; f < 6.2831855F; f += 1.0471976F) {
/*     */         
/* 574 */         pirate_game.this.pg.vertex(pirate_game.cos(f) * 0.5F, -0.2F, pirate_game.sin(f) * 0.5F);
/* 575 */         pirate_game.this.pg.vertex(pirate_game.cos(f + 1.0471976F) * 0.5F, -0.2F, pirate_game.sin(f + 1.0471976F) * 0.5F);
/* 576 */         pirate_game.this.pg.vertex(pirate_game.cos(f + 1.0471976F) * 0.5F, -10.0F, pirate_game.sin(f + 1.0471976F) * 0.5F);
/* 577 */         pirate_game.this.pg.vertex(pirate_game.cos(f) * 0.5F, -10.0F, pirate_game.sin(f) * 0.5F);
/*     */       } 
/* 579 */       pirate_game.this.pg.endShape();
/*     */       
/* 581 */       pirate_game.this.pg.fill(255);
/* 582 */       pirate_game.this.pg.beginShape(16);
/* 583 */       pirate_game.this.pg.vertex(0.0F, -3.5F, -4.712389F);
/* 584 */       pirate_game.this.pg.vertex(0.0F, -3.5F, 4.712389F);
/* 585 */       pirate_game.this.pg.vertex(0.0F, -10.0F, 1.8849558F);
/* 586 */       pirate_game.this.pg.vertex(0.0F, -10.0F, -1.8849558F);
/* 587 */       pirate_game.this.pg.endShape();
/* 588 */       pirate_game.this.pg.fill(0);
/* 589 */       pirate_game.this.pg.beginShape(9);
/* 590 */       pirate_game.this.pg.vertex(0.0F, -9.9F, -0.31415927F);
/* 591 */       pirate_game.this.pg.vertex(0.0F, -10.7F, 2.5132742F);
/* 592 */       pirate_game.this.pg.vertex(0.0F, -11.5F, -0.31415927F);
/* 593 */       pirate_game.this.pg.endShape();
/*     */       
/* 595 */       pirate_game.this.pg.translate(4.0F, 0.0F, 0.0F);
/*     */       
/* 597 */       pirate_game.this.pg.fill(139.0F, 69.0F, 19.0F);
/* 598 */       pirate_game.this.pg.beginShape(16);
/* 599 */       for (f = 0.0F; f < 6.2831855F; f += 1.5707964F) {
/*     */         
/* 601 */         pirate_game.this.pg.vertex(pirate_game.cos(f) * 0.5F, -0.2F, pirate_game.sin(f) * 0.5F);
/* 602 */         pirate_game.this.pg.vertex(pirate_game.cos(f + 1.5707964F) * 0.5F, -0.2F, pirate_game.sin(f + 1.5707964F) * 0.5F);
/* 603 */         pirate_game.this.pg.vertex(pirate_game.cos(f + 1.5707964F) * 0.5F, -8.0F, pirate_game.sin(f + 1.5707964F) * 0.5F);
/* 604 */         pirate_game.this.pg.vertex(pirate_game.cos(f) * 0.5F, -8.0F, pirate_game.sin(f) * 0.5F);
/*     */       } 
/* 606 */       pirate_game.this.pg.endShape();
/*     */       
/* 608 */       pirate_game.this.pg.fill(255);
/* 609 */       pirate_game.this.pg.beginShape(16);
/* 610 */       pirate_game.this.pg.vertex(0.0F, -3.5F, -3.1415927F);
/* 611 */       pirate_game.this.pg.vertex(0.0F, -3.5F, 3.1415927F);
/* 612 */       pirate_game.this.pg.vertex(0.0F, -8.0F, 1.2566371F);
/* 613 */       pirate_game.this.pg.vertex(0.0F, -8.0F, -1.2566371F);
/* 614 */       pirate_game.this.pg.endShape();
/*     */       
/* 616 */       pirate_game.this.pg.translate(2.0F, -2.5F, 0.0F);
/*     */       
/* 618 */       pirate_game.this.pg.fill(90.0F, 45.0F, 10.0F);
/* 619 */       pirate_game.this.pg.box(2.0F);
/*     */       
/* 621 */       pirate_game.this.pg.rotateZ(-0.3926991F);
/* 622 */       pirate_game.this.pg.fill(0);
/* 623 */       pirate_game.this.pg.beginShape(16);
/* 624 */       for (f = 0.0F; f < 6.2831855F; f += 1.5707964F) {
/*     */         
/* 626 */         pirate_game.this.pg.vertex(0.0F, pirate_game.cos(f) * 0.5F, pirate_game.sin(f) * 0.5F);
/* 627 */         pirate_game.this.pg.vertex(0.0F, pirate_game.cos(f + 1.5707964F) * 0.5F, pirate_game.sin(f + 1.5707964F) * 0.5F);
/* 628 */         pirate_game.this.pg.vertex(3.0F, pirate_game.cos(f + 1.5707964F) * 0.5F, pirate_game.sin(f + 1.5707964F) * 0.5F);
/* 629 */         pirate_game.this.pg.vertex(3.0F, pirate_game.cos(f) * 0.5F, pirate_game.sin(f) * 0.5F);
/*     */       } 
/* 631 */       pirate_game.this.pg.endShape();
/*     */       
/* 633 */       pirate_game.this.pg.popMatrix();
/*     */     } }
/*     */   
/*     */   public class Player { float x;
/*     */     float y;
/*     */     float z;
/* 639 */     float speed = 0.8F; float orientation; float cameraAng; float cannonTimer; public boolean w; public boolean s; public boolean a;
/*     */     public boolean d;
/*     */     public boolean space;
/*     */     
/*     */     public Player(float param1Float1, float param1Float2, float param1Float3) {
/* 644 */       this.x = param1Float1;
/* 645 */       this.z = param1Float2;
/* 646 */       this.orientation = param1Float3;
/* 647 */       this.cameraAng = param1Float3 + 1.5707964F;
/*     */     }
/*     */ 
/*     */     
/*     */     public void setCamera() {
/* 652 */       pirate_game.this.pg.camera(this.x - pirate_game.sin(this.cameraAng) * 30.0F, -12.0F, this.z - pirate_game.cos(this.cameraAng) * 30.0F, 
/* 653 */           this.x, -12.0F, this.z, 
/* 654 */           0.0F, 1.0F, 0.0F);
/*     */     }
/*     */ 
/*     */     
/*     */     public void update() {
/* 659 */       if (this.space && pirate_game.this.millis() - this.cannonTimer >= 1000.0F) {
/*     */         
/* 661 */         pirate_game.this.cannonballs.add(new pirate_game.Cannonball(this.x + pirate_game.cos(-this.orientation) * 3.0F, this.z + pirate_game.sin(-this.orientation) * 3.0F, pirate_game.cos(-this.orientation), pirate_game.sin(-this.orientation), false));
/* 662 */         this.cannonTimer = pirate_game.this.millis();
/*     */       } 
/*     */       
/* 665 */       pirate_game.this.pg.pushMatrix();
/* 666 */       pirate_game.this.pg.rotateY(this.orientation);
/* 667 */       for (pirate_game.Cannonball cannonball : pirate_game.this.cannonballs) {
/* 668 */         if (cannonball.pirateBall && !cannonball.hitPlayer && 
/* 669 */           pirate_game.abs(cannonball.x - this.x) < 4.2831855F && pirate_game.abs(cannonball.z - this.z) < 2.1415927F) {
/*     */           
/* 671 */           pirate_game.this.lives--;
/* 672 */           cannonball.hitPlayer = true;
/*     */         } 
/* 674 */       }  pirate_game.this.pg.popMatrix();
/*     */       
/* 676 */       this.y = (pirate_game.sin(pirate_game.this.millis() / 235.61946F) - 2.0F) / 4.0F;
/*     */       
/* 678 */       if (this.w)
/*     */       {
/* 680 */         if (pirate_game.abs(this.z + pirate_game.sin(-this.orientation) * this.speed) < 995.0F && pirate_game.abs(this.x + pirate_game.cos(-this.orientation) * this.speed) < 995.0F) {
/*     */           
/* 682 */           this.z += pirate_game.sin(-this.orientation) * this.speed;
/* 683 */           this.x += pirate_game.cos(-this.orientation) * this.speed;
/*     */         } 
/*     */       }
/* 686 */       if (this.s)
/*     */       {
/* 688 */         if (pirate_game.abs(this.z - pirate_game.sin(-this.orientation) * this.speed) < 995.0F && pirate_game.abs(this.x - pirate_game.cos(-this.orientation) * this.speed) < 995.0F) {
/*     */           
/* 690 */           this.z -= pirate_game.sin(-this.orientation) * this.speed;
/* 691 */           this.x -= pirate_game.cos(-this.orientation) * this.speed;
/*     */         } 
/*     */       }
/* 694 */       if (this.a)
/* 695 */         this.orientation += 0.02F; 
/* 696 */       if (this.d) {
/* 697 */         this.orientation -= 0.02F;
/*     */       }
/*     */     }
/*     */     
/*     */     public void draw() {
/* 702 */       pirate_game.this.pg.pushMatrix();
/*     */       
/* 704 */       pirate_game.this.pg.translate(this.x, this.y, this.z);
/* 705 */       pirate_game.this.pg.rotateY(this.orientation);
/*     */       
/* 707 */       pirate_game.this.pg.fill(139.0F, 69.0F, 19.0F);
/* 708 */       pirate_game.this.pg.beginShape(16); float f;
/* 709 */       for (f = -6.2831855F; f < 6.2831855F; f += 1.0471976F) {
/* 710 */         for (float f1 = -6.2831855F; f1 < 6.2831855F; f1 += 1.0471976F) {
/*     */           
/* 712 */           pirate_game.this.pg.vertex(f, -pirate_game.min((pirate_game.pow(pirate_game.abs(f), 3.0F) * 1.2F + pirate_game.pow(pirate_game.abs(f1), 6.0F) / 200.0F) / 100.0F, 3.0F), f1 / 2.0F);
/* 713 */           pirate_game.this.pg.vertex(f + 1.0471976F, -pirate_game.min((pirate_game.pow(pirate_game.abs(f + 1.0471976F), 3.0F) * 1.2F + pirate_game.pow(pirate_game.abs(f1), 6.0F) / 200.0F) / 100.0F, 3.0F), f1 / 2.0F);
/* 714 */           pirate_game.this.pg.vertex(f + 1.0471976F, -pirate_game.min((pirate_game.pow(pirate_game.abs(f + 1.0471976F), 3.0F) * 1.2F + pirate_game.pow(pirate_game.abs(f1 + 1.0471976F), 6.0F) / 200.0F) / 100.0F, 3.0F), (f1 + 1.0471976F) / 2.0F);
/* 715 */           pirate_game.this.pg.vertex(f, -pirate_game.min((pirate_game.pow(pirate_game.abs(f), 3.0F) * 1.2F + pirate_game.pow(pirate_game.abs(f1 + 1.0471976F), 6.0F) / 200.0F) / 100.0F, 3.0F), (f1 + 1.0471976F) / 2.0F);
/*     */         } 
/* 717 */       }  pirate_game.this.pg.endShape();
/*     */       
/* 719 */       pirate_game.this.pg.translate(-2.0F, 0.0F, 0.0F);
/*     */       
/* 721 */       pirate_game.this.pg.fill(139.0F, 69.0F, 19.0F);
/* 722 */       pirate_game.this.pg.beginShape(16);
/* 723 */       for (f = 0.0F; f < 6.2831855F; f += 0.3926991F) {
/*     */         
/* 725 */         pirate_game.this.pg.vertex(pirate_game.cos(f) * 0.5F, -0.2F, pirate_game.sin(f) * 0.5F);
/* 726 */         pirate_game.this.pg.vertex(pirate_game.cos(f + 0.3926991F) * 0.5F, -0.2F, pirate_game.sin(f + 0.3926991F) * 0.5F);
/* 727 */         pirate_game.this.pg.vertex(pirate_game.cos(f + 0.3926991F) * 0.5F, -10.0F, pirate_game.sin(f + 0.3926991F) * 0.5F);
/* 728 */         pirate_game.this.pg.vertex(pirate_game.cos(f) * 0.5F, -10.0F, pirate_game.sin(f) * 0.5F);
/*     */       } 
/* 730 */       pirate_game.this.pg.endShape();
/*     */       
/* 732 */       pirate_game.this.pg.fill(255);
/* 733 */       pirate_game.this.pg.beginShape(16);
/* 734 */       pirate_game.this.pg.vertex(0.0F, -3.5F, -4.712389F);
/* 735 */       pirate_game.this.pg.vertex(0.0F, -3.5F, 4.712389F);
/* 736 */       pirate_game.this.pg.vertex(0.0F, -10.0F, 1.8849558F);
/* 737 */       pirate_game.this.pg.vertex(0.0F, -10.0F, -1.8849558F);
/* 738 */       pirate_game.this.pg.endShape();
/* 739 */       pirate_game.this.pg.fill(0);
/* 740 */       pirate_game.this.pg.beginShape(9);
/* 741 */       pirate_game.this.pg.vertex(0.0F, -9.9F, -0.31415927F);
/* 742 */       pirate_game.this.pg.vertex(0.0F, -10.7F, 2.5132742F);
/* 743 */       pirate_game.this.pg.vertex(0.0F, -11.5F, -0.31415927F);
/* 744 */       pirate_game.this.pg.endShape();
/*     */       
/* 746 */       pirate_game.this.pg.translate(4.0F, 0.0F, 0.0F);
/*     */       
/* 748 */       pirate_game.this.pg.fill(139.0F, 69.0F, 19.0F);
/* 749 */       pirate_game.this.pg.beginShape(16);
/* 750 */       for (f = 0.0F; f < 6.2831855F; f += 0.3926991F) {
/*     */         
/* 752 */         pirate_game.this.pg.vertex(pirate_game.cos(f) * 0.5F, -0.2F, pirate_game.sin(f) * 0.5F);
/* 753 */         pirate_game.this.pg.vertex(pirate_game.cos(f + 0.3926991F) * 0.5F, -0.2F, pirate_game.sin(f + 0.3926991F) * 0.5F);
/* 754 */         pirate_game.this.pg.vertex(pirate_game.cos(f + 0.3926991F) * 0.5F, -8.0F, pirate_game.sin(f + 0.3926991F) * 0.5F);
/* 755 */         pirate_game.this.pg.vertex(pirate_game.cos(f) * 0.5F, -8.0F, pirate_game.sin(f) * 0.5F);
/*     */       } 
/* 757 */       pirate_game.this.pg.endShape();
/*     */       
/* 759 */       pirate_game.this.pg.fill(255);
/* 760 */       pirate_game.this.pg.beginShape(16);
/* 761 */       pirate_game.this.pg.vertex(0.0F, -3.5F, -3.1415927F);
/* 762 */       pirate_game.this.pg.vertex(0.0F, -3.5F, 3.1415927F);
/* 763 */       pirate_game.this.pg.vertex(0.0F, -8.0F, 1.2566371F);
/* 764 */       pirate_game.this.pg.vertex(0.0F, -8.0F, -1.2566371F);
/* 765 */       pirate_game.this.pg.endShape();
/*     */       
/* 767 */       pirate_game.this.pg.translate(2.0F, -2.5F, 0.0F);
/*     */       
/* 769 */       pirate_game.this.pg.fill(90.0F, 45.0F, 10.0F);
/* 770 */       pirate_game.this.pg.box(2.0F);
/*     */       
/* 772 */       pirate_game.this.pg.rotateZ(-0.3926991F);
/* 773 */       pirate_game.this.pg.fill(0);
/* 774 */       pirate_game.this.pg.beginShape(16);
/* 775 */       for (f = 0.0F; f < 6.2831855F; f += 0.3926991F) {
/*     */         
/* 777 */         pirate_game.this.pg.vertex(0.0F, pirate_game.cos(f) * 0.5F, pirate_game.sin(f) * 0.5F);
/* 778 */         pirate_game.this.pg.vertex(0.0F, pirate_game.cos(f + 0.3926991F) * 0.5F, pirate_game.sin(f + 0.3926991F) * 0.5F);
/* 779 */         pirate_game.this.pg.vertex(3.0F, pirate_game.cos(f + 0.3926991F) * 0.5F, pirate_game.sin(f + 0.3926991F) * 0.5F);
/* 780 */         pirate_game.this.pg.vertex(3.0F, pirate_game.cos(f) * 0.5F, pirate_game.sin(f) * 0.5F);
/*     */       } 
/* 782 */       pirate_game.this.pg.endShape();
/*     */       
/* 784 */       pirate_game.this.pg.popMatrix();
/*     */     } }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void drawSea() {
/* 792 */     if (!this.paused)
/* 793 */       this.seaAnim = (sin(millis() / 235.61946F) - 2.0F) / 2.0F; 
/* 794 */     this.pg.fill(40.0F, 80.0F, 160.0F);
/* 795 */     this.pg.beginShape(16);
/* 796 */     for (float f = 31.415928F * round(this.player.x / 31.415928F) - 94.24778F; f < 31.415928F * round(this.player.x / 31.415928F) + 94.24778F; f += 3.1415927F) {
/* 797 */       for (float f1 = (30 * round(this.player.z / 30.0F)) - 94.24778F; f1 < (30 * round(this.player.z / 30.0F)) + 94.24778F; f1 += 3.1415927F) {
/*     */         
/* 799 */         this.pg.vertex(f, this.seaAnim * pow(sin(f * 3.1415927F * 10.0F), 2.0F) / 2.0F + this.seaAnim * cos(f1 * 3.1415927F * 10.0F) / 5.0F, f1);
/* 800 */         this.pg.vertex(f + 3.1415927F, this.seaAnim * pow(sin((f + 3.1415927F) * 3.1415927F * 10.0F), 2.0F) / 2.0F + this.seaAnim * cos(f1 * 3.1415927F * 10.0F) / 5.0F, f1);
/* 801 */         this.pg.vertex(f + 3.1415927F, this.seaAnim * pow(sin((f + 3.1415927F) * 3.1415927F * 10.0F), 2.0F) / 2.0F + this.seaAnim * cos((f1 + 3.1415927F) * 3.1415927F * 10.0F) / 5.0F, f1 + 3.1415927F);
/* 802 */         this.pg.vertex(f, this.seaAnim * pow(sin(f * 3.1415927F * 10.0F), 2.0F) / 2.0F + this.seaAnim * cos((f1 + 3.1415927F) * 3.1415927F * 10.0F) / 5.0F, f1 + 3.1415927F);
/*     */       } 
/* 804 */     }  this.pg.endShape();
/*     */     
/* 806 */     this.pg.beginShape(16);
/* 807 */     this.pg.vertex(-2000.0F, 0.0F, -2000.0F);
/* 808 */     this.pg.vertex(2000.0F, 0.0F, -2000.0F);
/* 809 */     this.pg.vertex(2000.0F, 0.0F, 2000.0F);
/* 810 */     this.pg.vertex(-2000.0F, 0.0F, 2000.0F);
/* 811 */     this.pg.endShape();
/*     */   }
/*     */ 
/*     */   
/*     */   public void drawFence() {
/* 816 */     this.pg.fill(90.0F, 45.0F, 10.0F); short s;
/* 817 */     for (s = -1000; s < 1000; s += 100) {
/*     */       
/* 819 */       this.pg.pushMatrix();
/* 820 */       this.pg.translate(s, 0.0F, -1000.0F);
/* 821 */       this.pg.box(1.5F, 10.0F, 1.5F);
/* 822 */       this.pg.translate(50.0F, -3.0F, 0.0F);
/* 823 */       this.pg.box(100.0F, 1.2F, 1.2F);
/* 824 */       this.pg.popMatrix();
/*     */     } 
/* 826 */     for (s = -1000; s <= 1000; s += 100) {
/*     */       
/* 828 */       this.pg.pushMatrix();
/* 829 */       this.pg.translate(s, 0.0F, 1000.0F);
/* 830 */       this.pg.box(1.5F, 10.0F, 1.5F);
/* 831 */       if (s != 1000) {
/*     */         
/* 833 */         this.pg.translate(50.0F, -3.0F, 0.0F);
/* 834 */         this.pg.box(100.0F, 1.2F, 1.2F);
/*     */       } 
/* 836 */       this.pg.popMatrix();
/*     */     } 
/* 838 */     for (s = -1000; s < 1000; s += 100) {
/*     */       
/* 840 */       this.pg.pushMatrix();
/* 841 */       this.pg.translate(-1000.0F, 0.0F, s);
/* 842 */       this.pg.box(1.5F, 10.0F, 1.5F);
/* 843 */       this.pg.translate(0.0F, -3.0F, 50.0F);
/* 844 */       this.pg.box(1.2F, 1.2F, 100.0F);
/* 845 */       this.pg.popMatrix();
/*     */     } 
/* 847 */     for (s = -1000; s < 1000; s += 100) {
/*     */       
/* 849 */       this.pg.pushMatrix();
/* 850 */       this.pg.translate(1000.0F, 0.0F, s);
/* 851 */       this.pg.box(1.5F, 10.0F, 1.5F);
/* 852 */       this.pg.translate(0.0F, -3.0F, 50.0F);
/* 853 */       this.pg.box(1.2F, 1.2F, 100.0F);
/* 854 */       this.pg.popMatrix();
/*     */     } 
/*     */   }
/*     */   
/*     */   public static void main(String[] paramArrayOfString) {
/* 859 */     PApplet.main(new String[] { "--bgcolor=#F0F0F0", "pirate_game" });
/*     */   }
/*     */ }


/* Location:              C:\Users\nicho\Downloads\PirateGame.zip!\lib\pirate_game.jar!\pirate_game.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */