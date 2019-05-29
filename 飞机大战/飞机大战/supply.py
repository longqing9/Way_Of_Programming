import pygame
from random import *

#发放补给奖励的类
class Bullet_Supply(pygame.sprite.Sprite):
    def __init__(self, bg_size):
        pygame.sprite.Sprite.__init__(self)
		#加载子弹升级的奖励的图片
        self.image = pygame.image.load("images/bullet_supply.png").convert_alpha()
        self.rect = self.image.get_rect()
		#设置补给奖励出现的初始位置
        self.width, self.height = bg_size[0], bg_size[1]
        self.rect.left, self.rect.bottom = \
                        randint(0, self.width - self.rect.width), -100
		#补给降落的速度设置为5
        self.speed = 5
        self.active = False
        self.mask = pygame.mask.from_surface(self.image)
	#在不超出屏幕的条件下，每次补给的位置的改变为5，超出屏幕删除补给图片
    def move(self):
        if self.rect.top < self.height:
            self.rect.top += self.speed
        else:
            self.active = False
	
	#位置改变时，放置补给的出现的位置在屏幕的最边缘，只显示一半
    def reset(self):
        self.active = True
        self.rect.left, self.rect.bottom = \
                        randint(0, self.width - self.rect.width), -100

#全屏补给的类                 
class Bomb_Supply(pygame.sprite.Sprite):
    def __init__(self, bg_size):
        pygame.sprite.Sprite.__init__(self)
		#加载补给的图片
        self.image = pygame.image.load("images/bomb_supply.png").convert_alpha()
        self.rect = self.image.get_rect()
        self.width, self.height = bg_size[0], bg_size[1]
		#补给触及我方战机，补给消失
        self.rect.left, self.rect.bottom = \
                        randint(0, self.width - self.rect.width), -100
        self.speed = 5
        self.active = False
        self.mask = pygame.mask.from_surface(self.image)
	#在不超出屏幕的条件下，每次补给的位置的改变为5，超出屏幕删除补给图片
    def move(self):
        if self.rect.top < self.height:
            self.rect.top += self.speed
        else:
            self.active = False
	#位置改变时，放置补给的出现的位置在屏幕的最边缘，只显示一半
    def reset(self):
        self.active = True
        self.rect.left, self.rect.bottom = \
                        randint(0, self.width - self.rect.width), -100                                          
