import pygame
#当子弹只有一列时，即此时子弹为普通的子弹
class Bullet1(pygame.sprite.Sprite):
    def __init__(self, position):
        pygame.sprite.Sprite.__init__(self)
		#加载普通子弹的图片
        self.image = pygame.image.load("images/bullet1.png").convert_alpha()
        self.rect = self.image.get_rect()
        self.rect.left, self.rect.top = position
		#设置普通子弹的速度
        self.speed = 12
        self.active = False
        self.mask = pygame.mask.from_surface(self.image)
	#子弹直线移动，
    def move(self):
        self.rect.top -= self.speed
		#超出屏幕子弹消失
        if self.rect.top < 0:
            self.active = False
	#设置子弹的出现的位置
    def reset(self, position):
        self.rect.left, self.rect.top = position
        self.active = True
#子弹升级，每次发射两列子弹
class Bullet2(pygame.sprite.Sprite):
    def __init__(self, position):
        pygame.sprite.Sprite.__init__(self)
		#加载超级子弹的图片
        self.image = pygame.image.load("images/bullet2.png").convert_alpha()
        self.rect = self.image.get_rect()
        self.rect.left, self.rect.top = position
        self.speed = 14
        self.active = False
        self.mask = pygame.mask.from_surface(self.image)

    def move(self):
        self.rect.top -= self.speed

        if self.rect.top < 0:
            self.active = False

    def reset(self, position):
        self.rect.left, self.rect.top = position
        self.active = True
    
